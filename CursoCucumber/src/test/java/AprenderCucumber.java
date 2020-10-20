import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AprenderCucumber {

	@Given("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	}

	@When("^executá-lo$")
	public void executáLo() throws Throwable {
	}

	@Then("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
	}

	private int contador = 0;

	@Given("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador = arg1;
	}

	@When("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Then("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
//	    System.out.println(arg1);
//	    System.out.println(contador);
//	    System.out.println(arg1 == contador);
		// Assert.assertTrue(arg1 == contador);
		Assert.assertEquals(arg1, contador);

	}

	Date entrega = new Date();

	@Given("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
	public void queAEntregaÉDia(int dia, int mes, int ano) throws Throwable {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, dia);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		entrega = cal.getTime();
	}

	// @When("^a entrega atrasar em (\\d+) dias$")
	@When("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if(tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if (tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, arg1);
	    }
	    entrega = cal.getTime();
	}

	@Then("^a entrega será efetuada (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuada(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);

	}

}
