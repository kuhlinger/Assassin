import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssassinManagerTest {

    public List<String> listMakerHelper() {
        List<String> list = new ArrayList<>();
        list.add("Grayson");
        list.add("Ocean");
        list.add("Chris");
        list.add("Dr. Han");
        list.add("Max");
        list.add("Frank");

        return list;
    }

    @Test
    public void constructorTest() {
        List<String> list = listMakerHelper();
        AssassinManager manager = new AssassinManager(list);

        manager.printKillRing();
    }

    @Test
    public void constructorNegativeTest() {
        try {
            List<String> fail = new ArrayList<>();
            AssassinManager manager = new AssassinManager(fail);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void isGameOverTest () {
        List<String> onePlayer = new ArrayList<>();
        onePlayer.add("Grayson");
        AssassinManager manager = new AssassinManager(onePlayer);
        Assert.assertTrue(manager.isGameOver());
    }

    @Test
    public void winnerTest () {
        List<String> winMan = new ArrayList<>();
        winMan.add("Grayson");

        AssassinManager manager = new AssassinManager(winMan);
        Assert.assertTrue(manager.winner().equals("Grayson"));
    }

    @Test
    public void killRingContainsTest () {
        List<String> list = listMakerHelper();
        AssassinManager manager = new AssassinManager(list);

        Assert.assertTrue(manager.killRingContains("grayson"));
        Assert.assertTrue(manager.killRingContains("OCEAN"));
        Assert.assertTrue(manager.killRingContains("CHRIS"));
        Assert.assertTrue(manager.killRingContains("dr. han"));
        Assert.assertTrue(manager.killRingContains("ErIc"));
        Assert.assertTrue(manager.killRingContains("FRANK"));
        Assert.assertTrue(manager.killRingContains("jOHN"));
    }

    @Test
    public void killRingContainsNegativeTest() {
        List<String> list = listMakerHelper();
        AssassinManager manager = new AssassinManager(list);

        Assert.assertFalse(manager.killRingContains("grayson"));
        Assert.assertFalse(manager.killRingContains("ocean"));
        Assert.assertFalse(manager.killRingContains("max"));
        Assert.assertFalse(manager.killRingContains("Dr. han"));
        Assert.assertFalse(manager.killRingContains("BRADY"));
        Assert.assertFalse(manager.killRingContains("KarL"));
    }
    @Test
    public void killTest () {
        List<String> list = listMakerHelper();
        AssassinManager testMan = new AssassinManager(list);

        testMan.kill("Grayson");
        Assert.assertFalse(testMan.killRingContains("gRayson"));

        testMan.kill("Ocean");
        Assert.assertFalse(testMan.killRingContains("OCEAN"));

        testMan.kill("Chris");
        Assert.assertFalse(testMan.killRingContains("chris"));

        testMan.kill("Dr. Han");
        Assert.assertFalse(testMan.killRingContains("DR. HAN"));
    }

    @Test
    public void killNegativeTest () {
        try {
            List<String> list1 = new ArrayList<>();
            list1.add("Grayson");
            AssassinManager manTest = new AssassinManager(list1);
            manTest.kill("g");
            Assert.fail();
        } catch (IllegalStateException e) {
        }
    }


    @Test
    public void graveyardContainsTest () {
        List<String> list = listMakerHelper();
        AssassinManager testMan = new AssassinManager(list);

        testMan.printKillRing();
        testMan.kill("grayson");
        testMan.printGraveyard();
        Assert.assertTrue(testMan.graveyardContains("grayson"));

    }

    @Test
    public void graveyardContainsNegtiveTest(){
        List<String> list1= new ArrayList<String>();
        list1.add("Grayson");
        list1.add("Ocean");
        list1.add("Chris");
        list1.add("Dr.Han");

        AssassinManager manager = new AssassinManager(list1);
        manager.kill("Grayson");
        Assert.assertFalse(manager.graveyardContains("ocean"));
    }


}


