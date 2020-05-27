package br.com.guilhermealvessilve;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;

import br.com.guilhermealvessilve.entity.Produto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.DisabledOnNativeImage;
import io.quarkus.test.junit.QuarkusTest;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProdutoTest {
	
	@Test
	@DisabledOnNativeImage
	@DataSet("datarider/produtos1.yml")
	public void shouldTestProduto() {
		Assert.assertEquals(1, Produto.count());
	}
}
