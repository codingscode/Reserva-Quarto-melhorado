package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import excecoes.Excecoes;

public class Reserva {
	
	private Integer numeroquarto;
	private Date chegada;
	private Date saida;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  //perpassador
	
	public Reserva() {
	}

	public Reserva(Integer numeroquarto, Date chegada, Date saida) {
		if(!saida.after(chegada)) {
		   throw new Excecoes("Data de saída deve ser depois da data de entrada");
		}
		this.numeroquarto = numeroquarto;
		this.chegada = chegada;
		this.saida = saida;
	}

	public Integer getNumeroquarto() {
		return numeroquarto;
	}

	public void setNumeroquarto(Integer numeroquarto) {
		this.numeroquarto = numeroquarto;
	}

	public Date getChegada() {
		return chegada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duracao() {
	  long diferenca = saida.getTime() - chegada.getTime();
	  return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public void atualizardatas(Date chegada, Date saida) {
        Date agora = new Date();                            // EM RELAÇÃO A DATA DE HOJE
		if (chegada.before(agora) || saida.before(agora)) {
			throw new Excecoes("Datas de reserva para atualização devem ser datas futuras");
		}
		if (!saida.after(chegada)) {
			throw new Excecoes("Data de saída deve ser depois da data de chegada");  
		}
        this.chegada = chegada;
		this.saida = saida;
        
	}
	
	@Override
	public String toString() {
		return "Quarto " 
	           + numeroquarto 
	           + ", saída: " 
	           + sdf.format(chegada) 
	           + ", saida: " 
	           + sdf.format(saida) 
	           + ", "
			   + duracao() 
			   + " noites";
    }
	
}
