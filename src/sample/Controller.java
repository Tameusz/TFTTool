package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Button start;

    @FXML
    private Button aboutGame;

    @FXML
    private Button aboutApp;

    @FXML
    private Button exit;

    @FXML
    private Button returnButton;

    @FXML
    private ImageView textField;

    @FXML
    private Text aboutText;

    private Scene mainScene;

    List<Champion> champions = new ArrayList<>();

    @FXML
    void onActionAboutApp(ActionEvent event) {
        if (textField.isVisible() == false && aboutText.isVisible() == false) {
            textField.setVisible(true);
            aboutText.setVisible(true);
            aboutText.setText("Narzędzie ma Ci pomóc w utworzeniu przykładowego decku w grze teamfight tactics!\n" +
            "Po prostu przemieczczaj postacie z listy postaci na pola szachownicy po nałożeniu postaci na pole zostaną zaktualizowane dane na temat buffów (prawa strona)");
        } else {
            textField.setVisible(false);
            aboutText.setVisible(false);
        }
    }

    @FXML
    void onActionAboutGame(ActionEvent event) {
        if(textField.isVisible() == false && aboutText.isVisible() == false) {
            textField.setVisible(true);
            aboutText.setVisible(true);
            aboutText.setText("W każdym meczu znajduje się ośmiu graczy. Każdy z nich ma swoją planszę, na której przygotowuje jednostki do walki, „ławkę rezerwowych”, gdzie znajdują się jednostki zapasowe, nie biorące udziału w pojedynku oraz pieniądze do wydania.\n" +
                    "Mecz dzieli się na etapy. Każdy etap z kolei to faza przygotowania oraz walki. Podczas pierwszej fazy w dolnej części naszego ekranu pojawia się pięć losowych jednostek do kupienia. Możemy zdecydować się na dołączenie ich do naszej armii w zamian za odpowiednią liczbę sztuk złota, wrzucić je na ławkę, z nadzieją na wykorzystanie w przyszłości lub całkowicie zignorować.\n" +
                    "W drugiej fazie naprzeciwko nas staje armia jednego z siedmiu grających przeciwko nam zawodników. Od tego momentu, tracimy kontrolę nad naszymi jednostkami, stąd nazwa „Auto Battler”. Walka odbywa się automatycznie, a jej zwycięzca zadaje obrażenia przeciwnikowi zależne od liczby jego jednostek utrzymanych przy życiu. Jeżeli liczba naszych punktów zdrowia spadnie do zera, przegrywamy grę.");
        } else {
            textField.setVisible(false);
            aboutText.setVisible(false);
        }
    }

    @FXML
    void onActionStart(ActionEvent event) {
        initChamps();
        championPoolImages();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionExit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void onActionReturn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionSave(ActionEvent event) {
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Rectangle screenRectangle = new Rectangle(screenSize);
        //Robot robot = new Robot();
        //BufferedImage image = robot.createScreenCapture(screenRectangle);
        //File file = new File(fileName);
        //ImageIO.write(image, "png", file);
        //LOG.debug("A screenshot is captured to: " + file.getPath());
    }

    @FXML
    private Pane championPool;

    void championPoolImages() {
        //List<Image> images = new ArrayList<>();
        ImageView image = new ImageView("tft/champions/" + champions.get(0).getName() + ".png");
        //for(int i=0;i<58;++i) {
        //    images.add(new Image("tft/champions/" + champions.get(0).getName() + ".png"));
        //}
        //ImageView imageView = new ImageView(image);
        championPool.getChildren().add(image);
    }

    void initChamps() {
        Champion aatrox = new Champion("aatrox");
        aatrox.addOrigin(Champion.Origins.CULTIST);
        aatrox.addClass(Champion.Classes.VANGUARD);
        Champion akali = new Champion("akali");
        akali.addOrigin(Champion.Origins.NINJA);
        akali.addClass(Champion.Classes.ASSASSIN);
        Champion annie = new Champion("annie");
        annie.addOrigin(Champion.Origins.FORTUNE);
        annie.addClass(Champion.Classes.MAGE);
        Champion aurelionSol = new Champion("aurelionSol");
        aurelionSol.addOrigin(Champion.Origins.DRAGONSOUL);
        aurelionSol.addClass(Champion.Classes.MAGE);
        Champion azir = new Champion("azir");
        azir.addOrigin(Champion.Origins.WARLORD);
        azir.addClass(Champion.Classes.KEEPER);
        azir.addClass(Champion.Classes.EMPEROR);
        Champion brand = new Champion("brand");
        brand.addOrigin(Champion.Origins.DRAGONSOUL);
        brand.addClass(Champion.Classes.MAGE);
        Champion braum = new Champion("braum");
        braum.addOrigin(Champion.Origins.DRAGONSOUL);
        braum.addClass(Champion.Classes.VANGUARD);
        Champion chogath = new Champion("chogath");
        chogath.addOrigin(Champion.Origins.FABLED);
        chogath.addClass(Champion.Classes.BRAWLER);
        Champion darius = new Champion("darius");
        darius.addOrigin(Champion.Origins.FORTUNE);
        darius.addClass(Champion.Classes.SLAYER);
        Champion diana = new Champion("diana");
        diana.addOrigin(Champion.Origins.SPIRIT);
        diana.addClass(Champion.Classes.ASSASSIN);
        Champion elise = new Champion("elise");
        elise.addOrigin(Champion.Origins.CULTIST);
        elise.addClass(Champion.Classes.KEEPER);
        Champion fiora = new Champion("fiora");
        fiora.addOrigin(Champion.Origins.ENLIGHTENED);
        fiora.addClass(Champion.Classes.DUELIST);
        Champion garen = new Champion("garen");
        garen.addOrigin(Champion.Origins.WARLORD);
        garen.addClass(Champion.Classes.VANGUARD);
        Champion irelia = new Champion("irelia");
        irelia.addOrigin(Champion.Origins.ENLIGHTENED);
        irelia.addOrigin(Champion.Origins.DIVINE);
        irelia.addClass(Champion.Classes.ADEPT);
        Champion janna = new Champion("janna");
        janna.addOrigin(Champion.Origins.ENLIGHTENED);
        janna.addClass(Champion.Classes.MYSTIC);
        Champion jarvan = new Champion("jarvan");
        jarvan.addOrigin(Champion.Origins.WARLORD);
        jarvan.addClass(Champion.Classes.KEEPER);
        Champion jax = new Champion("jax");
        jax.addOrigin(Champion.Origins.DIVINE);
        jax.addClass(Champion.Classes.DUELIST);
        Champion kalista = new Champion("kalista");
        kalista.addOrigin(Champion.Origins.CULTIST);
        kalista.addClass(Champion.Classes.DUELIST);
        Champion katarina = new Champion("katarina");
        katarina.addOrigin(Champion.Origins.WARLORD);
        katarina.addOrigin(Champion.Origins.FORTUNE);
        kalista.addClass(Champion.Classes.ASSASSIN);
        Champion kayle = new Champion("kayle");
        kayle.addOrigin(Champion.Origins.DIVINE);
        kayle.addClass(Champion.Classes.EXECUTIONER);
        Champion kennen = new Champion("kennen");
        kennen.addOrigin(Champion.Origins.NINJA);
        kennen.addClass(Champion.Classes.KEEPER);
        Champion kindred = new Champion("kindred");
        kindred.addOrigin(Champion.Origins.SPIRIT);
        kindred.addClass(Champion.Classes.EXECUTIONER);
        Champion leeSin = new Champion("leeSin");
        leeSin.addOrigin(Champion.Origins.DIVINE);
        leeSin.addClass(Champion.Classes.DUELIST);
        Champion lulu = new Champion("lulu");
        lulu.addOrigin(Champion.Origins.ELDERWOOD);
        lulu.addClass(Champion.Classes.MAGE);
        Champion maokai = new Champion("maokai");
        maokai.addOrigin(Champion.Origins.ELDERWOOD);
        maokai.addClass(Champion.Classes.BRAWLER);
        Champion morgana = new Champion("morgana");
        morgana.addOrigin(Champion.Origins.ENLIGHTENED);
        morgana.addClass(Champion.Classes.SYPHONER);
        Champion nasus = new Champion("nasus");
        nasus.addOrigin(Champion.Origins.DIVINE);
        nasus.addClass(Champion.Classes.SYPHONER);
        Champion nautilus = new Champion("nautilus");
        nautilus.addOrigin(Champion.Origins.FABLED);
        nautilus.addClass(Champion.Classes.VANGUARD);
        Champion neeko = new Champion("neeko");
        neeko.addOrigin(Champion.Origins.FABLED);
        neeko.addClass(Champion.Classes.MYSTIC);
        Champion nidalee = new Champion("nidalee");
        nidalee.addOrigin(Champion.Origins.WARLORD);
        nidalee.addClass(Champion.Classes.SHARPSHOOTER);
        Champion nunu = new Champion("nunu");
        nunu.addOrigin(Champion.Origins.ELDERWOOD);
        nunu.addClass(Champion.Classes.BRAWLER);
        Champion olaf = new Champion("olaf");
        olaf.addOrigin(Champion.Origins.DRAGONSOUL);
        olaf.addClass(Champion.Classes.SLAYER);
        Champion ornn = new Champion("ornn");
        ornn.addOrigin(Champion.Origins.ELDERWOOD);
        ornn.addClass(Champion.Classes.BLACKSMITH);
        ornn.addClass(Champion.Classes.VANGUARD);
        Champion pyke = new Champion("pyke");
        pyke.addOrigin(Champion.Origins.CULTIST);
        pyke.addClass(Champion.Classes.ASSASSIN);
        pyke.addClass(Champion.Classes.SLAYER);
        Champion rakan = new Champion("rakan");
        rakan.addOrigin(Champion.Origins.ELDERWOOD);
        rakan.addClass(Champion.Classes.KEEPER);
        Champion samira = new Champion("samira");
        samira.addOrigin(Champion.Origins.DAREDEVIL);
        samira.addClass(Champion.Classes.SHARPSHOOTER);
        samira.addClass(Champion.Classes.SLAYER);
        Champion sejuani = new Champion("sejuani");
        sejuani.addOrigin(Champion.Origins.FORTUNE);
        sejuani.addClass(Champion.Classes.VANGUARD);
        Champion sett = new Champion("sett");
        sett.addOrigin(Champion.Origins.BOSS);
        sett.addClass(Champion.Classes.BRAWLER);
        Champion shen = new Champion("shen");
        shen.addOrigin(Champion.Origins.NINJA);
        shen.addClass(Champion.Classes.ADEPT);
        shen.addClass(Champion.Classes.MYSTIC);
        Champion shyvana = new Champion("shyvana");
        shyvana.addOrigin(Champion.Origins.DRAGONSOUL);
        shyvana.addClass(Champion.Classes.BRAWLER);
        Champion sivir = new Champion("sivir");
        sivir.addOrigin(Champion.Origins.CULTIST);
        sivir.addClass(Champion.Classes.SHARPSHOOTER);
        Champion swain = new Champion("swain");
        swain.addOrigin(Champion.Origins.DRAGONSOUL);
        swain.addClass(Champion.Classes.SYPHONER);
        Champion tahmKench = new Champion("tahmKench");
        tahmKench.addOrigin(Champion.Origins.FORTUNE);
        tahmKench.addClass(Champion.Classes.BRAWLER);
        Champion talon = new Champion("talon");
        talon.addOrigin(Champion.Origins.ENLIGHTENED);
        talon.addClass(Champion.Classes.ASSASSIN);
        Champion teemo = new Champion("teemo");
        teemo.addOrigin(Champion.Origins.SPIRIT);
        teemo.addClass(Champion.Classes.SHARPSHOOTER);
        Champion tristana = new Champion("tristana");
        tristana.addOrigin(Champion.Origins.DRAGONSOUL);
        tristana.addClass(Champion.Classes.SHARPSHOOTER);
        Champion tryndamere = new Champion("tryndamere");
        tryndamere.addOrigin(Champion.Origins.WARLORD);
        tryndamere.addClass(Champion.Classes.DUELIST);
        tryndamere.addClass(Champion.Classes.SLAYER);
        Champion twistedFate = new Champion("twistedFate");
        twistedFate.addOrigin(Champion.Origins.CULTIST);
        twistedFate.addClass(Champion.Classes.MAGE);
        Champion veigar = new Champion("veigar");
        veigar.addOrigin(Champion.Origins.ELDERWOOD);
        veigar.addClass(Champion.Classes.MAGE);
        Champion vi = new Champion("vi");
        vi.addOrigin(Champion.Origins.WARLORD);
        vi.addClass(Champion.Classes.BRAWLER);
        Champion vladimir = new Champion("vladimir");
        vladimir.addOrigin(Champion.Origins.CULTIST);
        vladimir.addClass(Champion.Classes.SYPHONER);
        Champion wukong = new Champion("wukong");
        wukong.addOrigin(Champion.Origins.DIVINE);
        wukong.addClass(Champion.Classes.VANGUARD);
        Champion xayah = new Champion("xayah");
        xayah.addOrigin(Champion.Origins.ELDERWOOD);
        xayah.addClass(Champion.Classes.EXECUTIONER);
        xayah.addClass(Champion.Classes.KEEPER);
        Champion yasuo = new Champion("yasuo");
        yasuo.addOrigin(Champion.Origins.EXILE);
        yasuo.addClass(Champion.Classes.DUELIST);
        Champion yone = new Champion("yone");
        yone.addOrigin(Champion.Origins.EXILE);
        yone.addClass(Champion.Classes.ADEPT);
        Champion yuumi = new Champion("yuumi");
        yuumi.addOrigin(Champion.Origins.SPIRIT);
        yuumi.addClass(Champion.Classes.MYSTIC);
        Champion zed = new Champion("zed");
        zed.addOrigin(Champion.Origins.NINJA);
        zed.addClass(Champion.Classes.SLAYER);
        Champion zilean = new Champion("zilean");
        zilean.addOrigin(Champion.Origins.CULTIST);
        zilean.addClass(Champion.Classes.MYSTIC);
        champions.add(aatrox);
        champions.add(akali);
        champions.add(annie);
        champions.add(aurelionSol);
        champions.add(azir);
        champions.add(brand);
        champions.add(braum);
        champions.add(chogath);
        champions.add(darius);
        champions.add(diana);
        champions.add(elise);
        champions.add(fiora);
        champions.add(garen);
        champions.add(irelia);
        champions.add(janna);
        champions.add(jarvan);
        champions.add(jax);
        champions.add(kalista);
        champions.add(katarina);
        champions.add(kayle);
        champions.add(kennen);
        champions.add(kindred);
        champions.add(leeSin);
        champions.add(lulu);
        champions.add(maokai);
        champions.add(morgana);
        champions.add(nasus);
        champions.add(nautilus);
        champions.add(neeko);
        champions.add(nidalee);
        champions.add(nunu);
        champions.add(olaf);
        champions.add(ornn);
        champions.add(pyke);
        champions.add(rakan);
        champions.add(samira);
        champions.add(sejuani);
        champions.add(sivir);
        champions.add(swain);
        champions.add(tahmKench);
        champions.add(talon);
        champions.add(teemo);
        champions.add(tristana);
        champions.add(tryndamere);
        champions.add(twistedFate);
        champions.add(veigar);
        champions.add(vi);
        champions.add(vladimir);
        champions.add(wukong);
        champions.add(xayah);
        champions.add(yasuo);
        champions.add(yone);
        champions.add(yuumi);
        champions.add(zed);
        champions.add(zilean);
    }
}