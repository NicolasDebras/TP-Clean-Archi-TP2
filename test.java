import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void testCompute() {
        App app = new App(); // Assurez-vous d'avoir une instance de votre classe App
        int result = app.Compute("assiette", "couscous", "coca", "moyen", "baba", "normal", "yes");
        Assert.assertEquals(18, result);
    }
}
