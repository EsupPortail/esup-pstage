package org.esupportail.pstage.utils;

public enum TypeCritere {
	CONVENTION,  
	OFFRE,PREMIER_NIVEAU, SECOND_NIVEAU;  
	       
	 
	         
	     
	      public Integer  get() {  
	          switch (this) {  
	              case CONVENTION:  
	                  return  new Integer(1); 
	              case OFFRE:  
	                  return  new Integer(2);
	              case PREMIER_NIVEAU:  
	                  return  new Integer(1);
	              case SECOND_NIVEAU:  
	                  return  new Integer(2);
	          }  
	          throw new RuntimeException(" Type enum non prevu ");  
	      }  
	   
	  
}
