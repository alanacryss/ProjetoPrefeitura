package br.ufrn.imd.lojaRapida.controle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * classe utilitária para adicionar mensagens no FacesMessage (objeto de view e dependente do JSF)
 * @author gleydson
 *
 */
public class MensagensUtil {

	public static void addInfo(String msg){
		FacesMessage fm = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage( null, fm);
	}
	
	public static void addError(String msg){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext.getCurrentInstance().addMessage( null, fm);
	}
	
	public static void addFatal(String msg){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "null", "null2");
		FacesContext.getCurrentInstance().addMessage( null, fm);
	}
	
	public static void addWarn(String msg){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "null", "null2");
		FacesContext.getCurrentInstance().addMessage( null, fm);
	}
	
	
}
