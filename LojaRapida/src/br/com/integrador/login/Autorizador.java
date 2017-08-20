package br.com.integrador.login;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();
		
		System.out.println("Entrou no autorizador");
		
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		
		ELContext elContext = context.getELContext();
		ELResolver elResolver = context.getApplication().getELResolver();
		UsuarioLogadoMBean usuarioLogado = (UsuarioLogadoMBean) elResolver.getValue(elContext, null, "usuarioLogadoBean");

		// Usando o usuarioLogado que foi injetado
		if (!usuarioLogado.isLogado()) {

			NavigationHandler handler = context.getApplication()
					.getNavigationHandler();
			handler.handleNavigation(context, null, "/faces/login/indexLogin?faces-redirect=true");
			
			//efetua renderizacao da tela
			context.renderResponse();
		}
	}	

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
	
	

}