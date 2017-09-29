package org.esupportail.pstage.services.stats;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.esupportail.pstagedata.domain.dto.StatisticItemDTO;
import org.esupportail.pstagedata.remote.RemoteServices;

public abstract class AbstractStatsBuilder {
	/**
	 * Prepare les methodes a appeler sur les stats 
	 */
	abstract public Map<String, String> prepareStats();



	private final transient Logger logger = Logger.getLogger(this.getClass());
	private static final double CENT = 100.0;
	private RemoteServices remoteServices;
	public RemoteServices getRemoteServices() {
		return remoteServices;
	}



	private List<String> anneesAccademiques;
	private ConteneurCriteresEtStats conteneurCriteresEtStats;




	/**
	 * Trouver puis executer les methodes stats de remotes : cas conventions 
	 * @param classe
	 * @param nomMethode
	 * @param typesDesParamatres
	 * @return
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Method trouverLaMethode(Class classe, 
			String nomMethode, 
			Class[] typesDesParamatres) throws NoSuchMethodException {
		if (classe == null) {
			throw new NoSuchMethodException(" Classe ou methode  inhexistante ");
		}
		try {

			return classe.getDeclaredMethod( nomMethode, typesDesParamatres );
		}
		catch (NoSuchMethodException ex) {
			return trouverLaMethode( classe.getSuperclass(), nomMethode, typesDesParamatres );
		}
			}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private  List<StatisticItemDTO> trouverConventionsParCriteres(RemoteServices remoteServices, String nommeth, Integer idCentre, String annee, String etat ) throws ClassNotFoundException{

		InvocationHandler mandataire = Proxy.getInvocationHandler(remoteServices);
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		Class[] interfaces = new Class[]{RemoteServices.class};

		Object proxy = java.lang.reflect.Proxy.newProxyInstance(contextClassLoader, interfaces, mandataire);

		Class clazz = proxy.getClass();

		if(logger.isDebugEnabled()){
			logger.debug(" classe de l'objet chaine " + clazz.getName());
		}

		List<StatisticItemDTO> sItemDTOs =null;
		try {
			Method laMethode = trouverLaMethode(clazz,nommeth, new Class[]{Integer.class, String.class, String.class});


			Object objets = laMethode.invoke(proxy, new Object[]{idCentre,annee,etat});

			sItemDTOs = (List<StatisticItemDTO>)objets;
		}
		catch (NoSuchMethodException ex) {
			StringBuilder builder = new StringBuilder(clazz.getName());
			builder.append(" ne dispose pas de la methode ");
			builder.append(nommeth);
			logger.error(builder.toString(), ex);
			throw new IllegalArgumentException(builder.toString(),ex);
		}
		catch (IllegalAccessException illex) {
			StringBuilder sb = new StringBuilder(" Pas de permissions necessessaires pour appeler");
			sb.append(nommeth);
			sb.append(" de la classe  ");
			sb.append(clazz.getName());
			logger.error(sb.toString(), illex);
			throw new IllegalArgumentException(sb.toString(),illex);
		}
		catch (InvocationTargetException ex) {

			throw new RuntimeException(" Probleme survenu : Echec su  la methode Ã  invoquer  ",ex);
		}

		return sItemDTOs;
	}



	protected void construireStatsParType(CriteresEtStats criteresEtStats, String secondCrit,String nomMeth, Integer idCentre, String etat) throws ClassNotFoundException{
		//criteresEtStats.setCritereSecondaire(secondCrit);
		List<StatisticItemDTO> statsItemsDtos = null;
		if(anneesAccademiques!=null  && !anneesAccademiques.isEmpty()){
			for(String annee : this.anneesAccademiques){
				statsItemsDtos = trouverConventionsParCriteres( remoteServices, nomMeth,  idCentre, annee, etat);

				if (statsItemsDtos!=null && !statsItemsDtos.isEmpty()){
					int total = 0;
					for (StatisticItemDTO unItem : statsItemsDtos){
						total = total + unItem.getNumber();
						if (logger.isDebugEnabled()){
							logger.debug("ConventionStatsController : total = "+total );	   		   
						}
					}
					for (StatisticItemDTO unItem : statsItemsDtos){

						unItem.setPercentage((unItem.getNumber()*CENT)/total);

					}
				}

				criteresEtStats.ajouter(annee, statsItemsDtos);
			}
		}

	}



	/**
	 * @param anneesAccademiques the anneesAccademiques to set
	 */
	public void setAnneesAccademiques(List<String> anneesAccademiques) {

		this.anneesAccademiques = anneesAccademiques;
	}


	public void construire(String choix2, String methode, Integer idCentreGestion, String etat) throws ClassNotFoundException {
		if(logger.isInfoEnabled()){
			logger.info(" Appel de AbstractStatsBuilder.construire ");
		}
		CriteresEtStats criteresEtStats = new CriteresEtStats();
		criteresEtStats.setCriterePrincipale(this.getConteneurCriteresEtStats().getCriterePrincipale());
		criteresEtStats.setCritereSecondaire(choix2);
		construireStatsParType(criteresEtStats, choix2, methode, idCentreGestion,etat);

		conteneurCriteresEtStats.ajouter(criteresEtStats);

	}


	/**
	 * @return the conteneurCriteresEtStats
	 */
	public ConteneurCriteresEtStats getConteneurCriteresEtStats() {
		return conteneurCriteresEtStats;
	}


	/**
	 * @param conteneurCriteresEtStats the conteneurCriteresEtStats to set
	 */
	public void setConteneurCriteresEtStats(
			ConteneurCriteresEtStats conteneurCriteresEtStats) {
		this.conteneurCriteresEtStats = conteneurCriteresEtStats;
	}


	/**
	 * @param remoteServices the remoteServices to set
	 */
	public void setRemoteServices(RemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

}
