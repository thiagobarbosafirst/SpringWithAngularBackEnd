package br.com.pbna.negocio;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RendimentoPoupancaJob {
	
	//Será sempre executado aos 0 segundos do minuto 0 da hora 0 no dia 1 de todos os meses
	private static final String CRON = "0 0 0 1 * ?";

	private static final Logger log = Logger.getLogger(RendimentoPoupancaJob.class);
	
	@Autowired
	private RendimentoPoupancaNegocio rendimentoPoupancaNegocio;
	
	@Scheduled(cron = CRON)
	public void executar() {
		rendimentoPoupanca();
	}
	
	private void rendimentoPoupanca() {
		log.info("Rendimento poupança iniciado");
		
		this.rendimentoPoupancaNegocio.gerarRendimentos();
		
		log.info("Rendimento finalizado");
	}


}
