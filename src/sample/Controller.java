package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private ImageView textField;

    @FXML
    private Text aboutText;

    @FXML
    private Pane mainScene;

    @FXML
    private Text buffs;

    @FXML
    private Text championInfo;

    @FXML
    private Pane place;

    @FXML
    private Pane championPool;
    //@FXML
    //private Pane mainScene;

    @FXML
    private ImageView aatroxV,akaliV,annieV,aurelionSolV,azirV,brandV,braumV,chogathV,dariusV,dianaV,eliseV,fioraV,garenV,ireliaV,
            jannaV,jarvanV,jaxV,kalistaV,katarinaV,kayleV,kennenV,kindredV,leeSinV,luluV,maokaiV,morganaV,nasusV,nautilusV,neekoV,nidaleeV,
            nunuV,olafV,ornnV,pykeV,rakanV,samiraV,sejuaniV,settV,shenV,shyvanaV,sivirV,swainV,tahmKenchV,talonV,teemoV,tristanaV,tryndamereV,
            twistedFateV,veigarV,viV,vladimirV,wukongV,xayahV,yasuoV,yoneV,yuumiV,zedV,zileanV;

    @FXML
    private ImageView aatroxB,akaliB,annieB,aurelionSolB,azirB,brandB,braumB,chogathB,dariusB,dianaB,eliseB,fioraB,garenB,ireliaB,
            jannaB,jarvanB,jaxB,kalistaB,katarinaB,kayleB,kennenB,kindredB,leeSinB,luluB,maokaiB,morganaB,nasusB,nautilusB,neekoB,nidaleeB,
            nunuB,olafB,ornnB,pykeB,rakanB,samiraB,sejuaniB,settB,shenB,shyvanaB,sivirB,swainB,tahmKenchB,talonB,teemoB,tristanaB,tryndamereB,
            twistedFateB,veigarB,viB,vladimirB,wukongB,xayahB,yasuoB,yoneB,yuumiB,zedB,zileanB;

    @FXML
    private ImageView cultist,divine,elderwood,enlightened,exile,fortune,ninja,boss,warlord,spirit,fabled,dragonsoul,daredevil,
            adept,assassin,brawler,duelist,emperor,keeper,mage,mystic,sharpshooter,vanguard,syphoner,slayer,executioner,blacksmith;


    ImageView[] imageViews;
    ImageView[] imageViewsB;
    ImageView[] imageViewsBuffs;
    boolean championInfoIsShowed = true;
    List<Champion> champions = new ArrayList<>();
    //origins CULTIST-0,DIVINE-1,ELDERWOOD-2,ENLIGHTENED-3,EXILE-4,FORTUNE-5,NINJA-6,BOSS-7,WARLORD-8,SPIRIT-9,FABLED-10,DRAGONSOUL-11,DAREDEVIL-12
    int[] buffsCountOrigins = new int[13];
    //classes ADEPT-0,ASSASSIN-1,BRAWLER-2,DUELIST-3,EMPEROR-4,KEEPER-5,MAGE-6,MYSTIC-7,SHARPSHOOTER-8,VANGUARD-9,SYPHONER-10,SLAYER-11,EXECUTIONER-12,BLACKSMITH-13
    int[] buffsCountClasses = new int[14];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initViews();
        initChamps();
        initViewsB();
        initBuffs();
    }

    @FXML
    void onActionAboutApp(ActionEvent event) {
        if (textField.isVisible() == false && aboutText.isVisible() == false) {
            textField.setVisible(true);
            aboutText.setVisible(true);
            aboutText.setText("Narz??dzie ma Ci pom??c w utworzeniu przyk??adowego decku w grze teamfight tactics!\n" +
            "Po prostu przemieczczaj postacie z listy postaci na pola szachownicy po na??o??eniu postaci na pole zostan?? zaktualizowane dane na temat buff??w (prawa strona)\n" +
                    "Je??li chcesz si?? dowiedzie?? co daj?? wzmocnienia po prostu najed?? ikone w g??rnej cz??sci sceny.\n" +
                    "Aby pozna?? histori?? postaci oraz jakiego jest ona pochodzenia i jak?? ma klas?? kliknij na jego podobizn??.");
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
            aboutText.setText("W ka??dym meczu znajduje si?? o??miu graczy. Ka??dy z nich ma swoj?? plansz??, na kt??rej przygotowuje jednostki do walki," +
                    " ?????awk?? rezerwowych???, gdzie znajduj?? si?? jednostki zapasowe, nie bior??ce udzia??u w pojedynku oraz pieni??dze do wydania.\n" +
                    "Mecz dzieli si?? na etapy. Ka??dy etap z kolei to faza przygotowania oraz walki. Podczas pierwszej fazy w dolnej cz????ci naszego ekranu" +
                    " pojawia si?? pi???? losowych jednostek do kupienia. Mo??emy zdecydowa?? si?? na do????czenie ich do naszej armii w zamian za odpowiedni?? liczb?? sztuk z??ota," +
                    " wrzuci?? je na ??awk??, z nadziej?? na wykorzystanie w przysz??o??ci lub ca??kowicie zignorowa??.\n" +
                    "W drugiej fazie naprzeciwko nas staje armia jednego z siedmiu graj??cych przeciwko nam zawodnik??w. Od tego momentu, tracimy kontrol?? nad naszymi jednostkami," +
                    " st??d nazwa ???Auto Battler???. Walka odbywa si?? automatycznie, a jej zwyci??zca zadaje obra??enia przeciwnikowi zale??ne od liczby jego jednostek utrzymanych " +
                    "przy ??yciu. Je??eli liczba naszych punkt??w zdrowia spadnie do zera, przegrywamy gr??.");
        } else {
            textField.setVisible(false);
            aboutText.setVisible(false);
        }
    }

    @FXML
    void onActionStart(ActionEvent event) {
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
        try {
            FileWriter file = new FileWriter("yourbuild.txt");
            for(int i=0; i<place.getChildren().size(); ++i)
            file.append(place.getChildren().get(i).getId().replace("V","") + "\n" + place.getChildren().get(i).getScene().getX() + "\n" + place.getChildren().get(i).getScene().getY() + "\n");
            file.append(buffs.getText());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onActionLoad(ActionEvent event) {
        try {
            File file = new File("yourbuild.txt");
            Scanner scanner = new Scanner(file);
            String temp;
            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                for (int i = 0; i < champions.size(); ++i) {
                    if (champions.get(i).getName().toLowerCase().equals(temp)) {
                        place.getChildren().add(imageViews[i]);
                        imageViews[i].setX(Double.parseDouble(scanner.nextLine()));
                        imageViews[i].setY(Double.parseDouble(scanner.nextLine()));
                        break;
                    }
                }
                if(temp.equals(Champion.Classes.EMPEROR.toString())||temp.equals(Champion.Classes.ADEPT.toString())||temp.equals(Champion.Classes.ASSASSIN.toString())||temp.equals(Champion.Classes.BRAWLER.toString())||temp.equals(Champion.Classes.DUELIST.toString())||temp.equals(Champion.Classes.KEEPER.toString())||temp.equals(Champion.Classes.MAGE.toString())||temp.equals(Champion.Classes.MYSTIC.toString())||temp.equals(Champion.Classes.SHARPSHOOTER.toString())||temp.equals(Champion.Classes.VANGUARD.toString())||temp.equals(Champion.Classes.SYPHONER.toString())||temp.equals(Champion.Classes.SLAYER.toString())||temp.equals(Champion.Classes.EXECUTIONER.toString())||temp.equals(Champion.Classes.BLACKSMITH.toString())||
                   temp.equals(Champion.Origins.CULTIST.toString())||temp.equals(Champion.Origins.DIVINE.toString())||temp.equals(Champion.Origins.ELDERWOOD.toString())||temp.equals(Champion.Origins.ENLIGHTENED.toString())||temp.equals(Champion.Origins.EXILE.toString())||temp.equals(Champion.Origins.FORTUNE.toString())||temp.equals(Champion.Origins.NINJA.toString())||temp.equals(Champion.Origins.BOSS.toString())||temp.equals(Champion.Origins.WARLORD.toString())||temp.equals(Champion.Origins.SPIRIT.toString())||temp.equals(Champion.Origins.FABLED.toString())||temp.equals(Champion.Origins.DRAGONSOUL.toString())||temp.equals(Champion.Origins.DAREDEVIL.toString())) {
                    buffs.setText(buffs.getText() + temp + "\n");
                }
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //mouse events
    @FXML
    void enter(MouseEvent event) throws FileNotFoundException {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scanner scanner = new Scanner(new File("src/sample/tft/champions/" + stage.getTitle() + ".txt"));
            for (int i = 0; i < 58; ++i) {
                if (imageViewsB[i].getId().equals(stage.getTitle() + "B") && championInfoIsShowed) {
                    imageViewsB[i].setVisible(true);
                    while (scanner.hasNextLine()) {
                        championInfo.setText(championInfo.getText() + scanner.nextLine());
                    }
                    scanner.close();
                    championInfo.setText(championInfo.getText() + "\n\nPochodzenie:" + champions.get(i).getOrigins() + "\n\nKlasy:" + champions.get(i).getClasses());
                    championInfoIsShowed = false;
                }
            }
    }

    @FXML
    void mouseClick(MouseEvent event) {
        try {
            for(int i=0;i<58;++i) {
                if(event.getSource().equals(imageViews[i])) {
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("championInfo.fxml"));
                    stage.setTitle(champions.get(i).getName());
                    stage.setScene(new Scene(root, 1120 , 560));
                    stage.setX(260);
                    stage.setY(200);
                    stage.show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void done(DragEvent event) {
        //for(int i=0;i<58;++i) {
        //    if(event.getSource().equals(imageViews[i])) {
        //        //System.out.println(imageViews[i].getLayoutX());
        //        //System.out.println(imageViews[i].getLayoutY());
        //        event.consume();
        //    }
        //}
    }

    @FXML
    void drag(MouseEvent event) {
        for(int i=0;i<58;++i) {
            if(event.getSource().equals(imageViews[i])) {
                Dragboard db = imageViews[i].startDragAndDrop(TransferMode.ANY);

                ClipboardContent content = new ClipboardContent();
                content.putImage(imageViews[i].getImage());
                db.setContent(content);
                event.consume();
            }
        }
    }

    @FXML
    void drop(DragEvent event) {
        event.acceptTransferModes(TransferMode.ANY);
            for (int i = 0; i < 58; ++i) {
                if (event.getSource().equals(imageViews[i])) {
                    //boolean success = false;
                    //Node node = event.getPickResult().getIntersectedNode();
                    //if(node != championPool){
                    place.getChildren().add(imageViews[i]);
                    //success = true;
                    imageViews[i].setX(event.getX() - 23);
                    imageViews[i].setY(event.getY() - 23);
                    //}
                    //event.setDropCompleted(success);
                    if (imageViews[i].getId().equals(champions.get(i).getName() + "V")) {
//origins CULTIST-0,DIVINE-1,ELDERWOOD-2,ENLIGHTENED-3,EXILE-4,FORTUNE-5,NINJA-6,BOSS-7,WARLORD-8,SPIRIT-9,FABLED-10,DRAGONSOUL-11,DAREDEVIL-12
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.CULTIST)) {
                    buffsCountOrigins[0]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.DIVINE)) {
                    buffsCountOrigins[1]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.ELDERWOOD)) {
                    buffsCountOrigins[2]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.ENLIGHTENED)) {
                    buffsCountOrigins[3]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.EXILE)) {
                    buffsCountOrigins[4]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.FORTUNE)) {
                    buffsCountOrigins[5]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.NINJA)) {
                    buffsCountOrigins[6]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.BOSS)) {
                    buffsCountOrigins[7]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.WARLORD)) {
                    buffsCountOrigins[8]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.SPIRIT)) {
                    buffsCountOrigins[9]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.FABLED)) {
                    buffsCountOrigins[10]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.DRAGONSOUL)) {
                    buffsCountOrigins[11]++;
                }
                if (champions.get(i).getOrigins().get(0).equals(Champion.Origins.DAREDEVIL)) {
                    buffsCountOrigins[12]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.ADEPT)) {
                    buffsCountClasses[0]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.ASSASSIN)) {
                    buffsCountClasses[1]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.BRAWLER)) {
                    buffsCountClasses[2]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.DUELIST)) {
                    buffsCountClasses[3]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.EMPEROR)) {
                    buffsCountClasses[4]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.KEEPER)) {
                    buffsCountClasses[5]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.MAGE)) {
                    buffsCountClasses[6]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.MYSTIC)) {
                    buffsCountClasses[7]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.SHARPSHOOTER)) {
                    buffsCountClasses[8]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.VANGUARD)) {
                    buffsCountClasses[9]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.SYPHONER)) {
                    buffsCountClasses[10]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.SLAYER)) {
                    buffsCountClasses[11]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.EXECUTIONER)) {
                    buffsCountClasses[12]++;
                }
                if (champions.get(i).getClasses().get(0).equals(Champion.Classes.BLACKSMITH)) {
                    buffsCountClasses[13]++;
                }
                if (champions.get(i).getName().equals("azir")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.EMPEROR)) {
                        buffsCountClasses[4]++;
                    }
                }
                if (champions.get(i).getName().equals("irelia")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Origins.DIVINE)) {
                        buffsCountOrigins[1]++;
                    }
                }
                if (champions.get(i).getName().equals("katarina")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Origins.FORTUNE)) {
                        buffsCountOrigins[5]++;
                    }
                }
                if (champions.get(i).getName().equals("ornn")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.VANGUARD)) {
                        buffsCountClasses[9]++;
                    }
                }
                if (champions.get(i).getName().equals("pyke")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.SLAYER)) {
                        buffsCountClasses[11]++;
                    }
                }
                if (champions.get(i).getName().equals("samira")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.SLAYER)) {
                        buffsCountClasses[11]++;
                    }
                }
                if (champions.get(i).getName().equals("shen")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.MYSTIC)) {
                        buffsCountClasses[7]++;
                    }
                }
                if (champions.get(i).getName().equals("tryndamere")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.SLAYER)) {
                        buffsCountClasses[11]++;
                    }
                }
                if (champions.get(i).getName().equals("xayah")) {
                    if (champions.get(i).getClasses().get(1).equals(Champion.Classes.KEEPER)) {
                        buffsCountClasses[5]++;
                    }
                }
            }
                event.consume();
                }
            }

        {
            if(buffsCountOrigins[0]>=8) { buffs.setText(buffs.getText() + "\n"  + Champion.Origins.CULTIST); buffsCountOrigins[0]=0; }
            if(buffsCountOrigins[1]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.DIVINE); buffsCountOrigins[1]=0; }
            if(buffsCountOrigins[2]>=7) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.ELDERWOOD); buffsCountOrigins[2]=0; }
            if(buffsCountOrigins[3]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.ENLIGHTENED); buffsCountOrigins[3]=0; }
            if(buffsCountOrigins[4]>=2) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.EXILE); buffsCountOrigins[4]=0; }
            if(buffsCountOrigins[5]>=5) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.FORTUNE); buffsCountOrigins[5]=0; }
            if(buffsCountOrigins[6]>=4) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.NINJA); buffsCountOrigins[6]=0; }
            if(buffsCountOrigins[7]>=1) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.BOSS); buffsCountOrigins[7]=0; }
            if(buffsCountOrigins[8]>=7) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.WARLORD); buffsCountOrigins[8]=0; }
            if(buffsCountOrigins[9]>=4) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.SPIRIT); buffsCountOrigins[9]=0; }
            if(buffsCountOrigins[10]>=3) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.FABLED); buffsCountOrigins[10]=0; }
            if(buffsCountOrigins[11]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.DRAGONSOUL); buffsCountOrigins[11]=0; }
            if(buffsCountOrigins[12]>=1) { buffs.setText(buffs.getText() + "\n" + Champion.Origins.DAREDEVIL); buffsCountOrigins[12]=0; }
            if(buffsCountClasses[0]>=3) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.ADEPT); buffsCountClasses[0]=0; }
            if(buffsCountClasses[1]>=5) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.ASSASSIN); buffsCountClasses[1]=0; }
            if(buffsCountClasses[2]>=7) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.BRAWLER); buffsCountClasses[2]=0; }
            if(buffsCountClasses[3]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.DUELIST); buffsCountClasses[3]=0; }
            if(buffsCountClasses[4]>=1) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.EMPEROR); buffsCountClasses[4]=0; }
            if(buffsCountClasses[5]>=4) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.KEEPER); buffsCountClasses[5]=0; }
            if(buffsCountClasses[6]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.MAGE); buffsCountClasses[6]=0; }
            if(buffsCountClasses[7]>=4) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.MYSTIC); buffsCountClasses[7]=0; }
            if(buffsCountClasses[8]>=5) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.SHARPSHOOTER); buffsCountClasses[8]=0; }
            if(buffsCountClasses[9]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.VANGUARD); buffsCountClasses[9]=0; }
            if(buffsCountClasses[10]>=4) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.SYPHONER); buffsCountClasses[10]=0; }
            if(buffsCountClasses[11]>=6) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.SLAYER); buffsCountClasses[11]=0; }
            if(buffsCountClasses[12]>=3) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.EXECUTIONER); buffsCountClasses[12]=0; }
            if(buffsCountClasses[13]>=1) { buffs.setText(buffs.getText() + "\n" + Champion.Classes.BLACKSMITH); buffsCountClasses[13]=0; }
        }
    }

    @FXML
    void over(DragEvent event) {
        if(event.getDragboard().hasImage() && event.getGestureSource() != place) {
            event.acceptTransferModes(TransferMode.ANY);
            event.consume();
        }
    }



    @FXML
    void enterTooltip(MouseEvent event) {
        try {
        Tooltip tooltip = new Tooltip();
        tooltip.setShowDelay(new Duration(0.0));
        tooltip.setHideDelay(new Duration(0.0));
        tooltip.setStyle("-fx-font-size: 20");
            for (int i = 0; i < imageViewsBuffs.length; ++i) {
                if (event.getSource().equals(imageViewsBuffs[i])) {
                    //installing tooltips
                    Scanner scanner = new Scanner(new File("src/sample/tft/buffs/" + imageViewsBuffs[i].getId() + ".txt"));
                    while (scanner.hasNextLine()) {
                        tooltip.setText(tooltip.getText() + scanner.nextLine() + "\n");
                    }
                    Tooltip.install(imageViewsBuffs[i], tooltip);
                    //TODO: implement this someday to the working state
                    // for (int j=0;j<58;++j) {
                    //    System.out.println(champions.get(j).getOrigins().get(0));
                    //    System.out.println(imageViewsBuffs[i].getId().toUpperCase(Locale.ROOT));
                    //    if(champions.get(j).getOrigins().get(0).equals(imageViewsBuffs[i].getId().toUpperCase(Locale.ROOT))) {
                    //        imageViews[j].setStyle("border-style: solid; color:red");
                    //        System.out.println("i am here");
                    //    }
                    //}
                    //imageViews[0].setStyle("-fx-fill: red;");
                }
            }
            for(int i = 0; i < imageViews.length; ++i) {
                if (event.getSource().equals(imageViews[i])) {
                    tooltip.setText(imageViews[i].getId().replace("V", "").toUpperCase());
                    Tooltip.install(imageViews[i], tooltip);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    void initChamps() {
        Champion aatrox = new Champion("aatrox"); aatrox.addOrigin(Champion.Origins.CULTIST); aatrox.addClass(Champion.Classes.VANGUARD);
        Champion akali = new Champion("akali"); akali.addOrigin(Champion.Origins.NINJA); akali.addClass(Champion.Classes.ASSASSIN);
        Champion annie = new Champion("annie"); annie.addOrigin(Champion.Origins.FORTUNE); annie.addClass(Champion.Classes.MAGE);
        Champion aurelionSol = new Champion("aurelionSol"); aurelionSol.addOrigin(Champion.Origins.DRAGONSOUL); aurelionSol.addClass(Champion.Classes.MAGE);
        Champion azir = new Champion("azir"); azir.addOrigin(Champion.Origins.WARLORD); azir.addClass(Champion.Classes.KEEPER); azir.addClass(Champion.Classes.EMPEROR);
        Champion brand = new Champion("brand"); brand.addOrigin(Champion.Origins.DRAGONSOUL); brand.addClass(Champion.Classes.MAGE);
        Champion braum = new Champion("braum"); braum.addOrigin(Champion.Origins.DRAGONSOUL); braum.addClass(Champion.Classes.VANGUARD);
        Champion chogath = new Champion("chogath"); chogath.addOrigin(Champion.Origins.FABLED); chogath.addClass(Champion.Classes.BRAWLER);
        Champion darius = new Champion("darius"); darius.addOrigin(Champion.Origins.FORTUNE); darius.addClass(Champion.Classes.SLAYER);
        Champion diana = new Champion("diana"); diana.addOrigin(Champion.Origins.SPIRIT); diana.addClass(Champion.Classes.ASSASSIN);
        Champion elise = new Champion("elise"); elise.addOrigin(Champion.Origins.CULTIST); elise.addClass(Champion.Classes.KEEPER);
        Champion fiora = new Champion("fiora"); fiora.addOrigin(Champion.Origins.ENLIGHTENED); fiora.addClass(Champion.Classes.DUELIST);
        Champion garen = new Champion("garen"); garen.addOrigin(Champion.Origins.WARLORD); garen.addClass(Champion.Classes.VANGUARD);
        Champion irelia = new Champion("irelia"); irelia.addOrigin(Champion.Origins.ENLIGHTENED); irelia.addOrigin(Champion.Origins.DIVINE); irelia.addClass(Champion.Classes.ADEPT);
        Champion janna = new Champion("janna"); janna.addOrigin(Champion.Origins.ENLIGHTENED); janna.addClass(Champion.Classes.MYSTIC);
        Champion jarvan = new Champion("jarvan"); jarvan.addOrigin(Champion.Origins.WARLORD); jarvan.addClass(Champion.Classes.KEEPER);
        Champion jax = new Champion("jax"); jax.addOrigin(Champion.Origins.DIVINE); jax.addClass(Champion.Classes.DUELIST);
        Champion kalista = new Champion("kalista"); kalista.addOrigin(Champion.Origins.CULTIST); kalista.addClass(Champion.Classes.DUELIST);
        Champion katarina = new Champion("katarina"); katarina.addOrigin(Champion.Origins.WARLORD); katarina.addOrigin(Champion.Origins.FORTUNE); katarina.addClass(Champion.Classes.ASSASSIN);
        Champion kayle = new Champion("kayle"); kayle.addOrigin(Champion.Origins.DIVINE); kayle.addClass(Champion.Classes.EXECUTIONER);
        Champion kennen = new Champion("kennen"); kennen.addOrigin(Champion.Origins.NINJA); kennen.addClass(Champion.Classes.KEEPER);
        Champion kindred = new Champion("kindred"); kindred.addOrigin(Champion.Origins.SPIRIT); kindred.addClass(Champion.Classes.EXECUTIONER);
        Champion leeSin = new Champion("leeSin"); leeSin.addOrigin(Champion.Origins.DIVINE); leeSin.addClass(Champion.Classes.DUELIST);
        Champion lulu = new Champion("lulu"); lulu.addOrigin(Champion.Origins.ELDERWOOD); lulu.addClass(Champion.Classes.MAGE);
        Champion maokai = new Champion("maokai"); maokai.addOrigin(Champion.Origins.ELDERWOOD); maokai.addClass(Champion.Classes.BRAWLER);
        Champion morgana = new Champion("morgana"); morgana.addOrigin(Champion.Origins.ENLIGHTENED); morgana.addClass(Champion.Classes.SYPHONER);
        Champion nasus = new Champion("nasus"); nasus.addOrigin(Champion.Origins.DIVINE); nasus.addClass(Champion.Classes.SYPHONER);
        Champion nautilus = new Champion("nautilus"); nautilus.addOrigin(Champion.Origins.FABLED); nautilus.addClass(Champion.Classes.VANGUARD);
        Champion neeko = new Champion("neeko"); neeko.addOrigin(Champion.Origins.FABLED); neeko.addClass(Champion.Classes.MYSTIC);
        Champion nidalee = new Champion("nidalee"); nidalee.addOrigin(Champion.Origins.WARLORD); nidalee.addClass(Champion.Classes.SHARPSHOOTER);
        Champion nunu = new Champion("nunu"); nunu.addOrigin(Champion.Origins.ELDERWOOD); nunu.addClass(Champion.Classes.BRAWLER);
        Champion olaf = new Champion("olaf"); olaf.addOrigin(Champion.Origins.DRAGONSOUL); olaf.addClass(Champion.Classes.SLAYER);
        Champion ornn = new Champion("ornn"); ornn.addOrigin(Champion.Origins.ELDERWOOD); ornn.addClass(Champion.Classes.BLACKSMITH); ornn.addClass(Champion.Classes.VANGUARD);
        Champion pyke = new Champion("pyke"); pyke.addOrigin(Champion.Origins.CULTIST); pyke.addClass(Champion.Classes.ASSASSIN); pyke.addClass(Champion.Classes.SLAYER);
        Champion rakan = new Champion("rakan"); rakan.addOrigin(Champion.Origins.ELDERWOOD); rakan.addClass(Champion.Classes.KEEPER);
        Champion samira = new Champion("samira"); samira.addOrigin(Champion.Origins.DAREDEVIL); samira.addClass(Champion.Classes.SHARPSHOOTER); samira.addClass(Champion.Classes.SLAYER);
        Champion sejuani = new Champion("sejuani"); sejuani.addOrigin(Champion.Origins.FORTUNE); sejuani.addClass(Champion.Classes.VANGUARD);
        Champion sett = new Champion("sett"); sett.addOrigin(Champion.Origins.BOSS); sett.addClass(Champion.Classes.BRAWLER);
        Champion shen = new Champion("shen"); shen.addOrigin(Champion.Origins.NINJA); shen.addClass(Champion.Classes.ADEPT); shen.addClass(Champion.Classes.MYSTIC);
        Champion shyvana = new Champion("shyvana"); shyvana.addOrigin(Champion.Origins.DRAGONSOUL); shyvana.addClass(Champion.Classes.BRAWLER);
        Champion sivir = new Champion("sivir"); sivir.addOrigin(Champion.Origins.CULTIST); sivir.addClass(Champion.Classes.SHARPSHOOTER);
        Champion swain = new Champion("swain"); swain.addOrigin(Champion.Origins.DRAGONSOUL); swain.addClass(Champion.Classes.SYPHONER);
        Champion tahmKench = new Champion("tahmKench"); tahmKench.addOrigin(Champion.Origins.FORTUNE); tahmKench.addClass(Champion.Classes.BRAWLER);
        Champion talon = new Champion("talon"); talon.addOrigin(Champion.Origins.ENLIGHTENED); talon.addClass(Champion.Classes.ASSASSIN);
        Champion teemo = new Champion("teemo"); teemo.addOrigin(Champion.Origins.SPIRIT); teemo.addClass(Champion.Classes.SHARPSHOOTER);
        Champion tristana = new Champion("tristana"); tristana.addOrigin(Champion.Origins.DRAGONSOUL); tristana.addClass(Champion.Classes.SHARPSHOOTER);
        Champion tryndamere = new Champion("tryndamere"); tryndamere.addOrigin(Champion.Origins.WARLORD); tryndamere.addClass(Champion.Classes.DUELIST); tryndamere.addClass(Champion.Classes.SLAYER);
        Champion twistedFate = new Champion("twistedFate"); twistedFate.addOrigin(Champion.Origins.CULTIST); twistedFate.addClass(Champion.Classes.MAGE);
        Champion veigar = new Champion("veigar"); veigar.addOrigin(Champion.Origins.ELDERWOOD); veigar.addClass(Champion.Classes.MAGE);
        Champion vi = new Champion("vi"); vi.addOrigin(Champion.Origins.WARLORD); vi.addClass(Champion.Classes.BRAWLER);
        Champion vladimir = new Champion("vladimir"); vladimir.addOrigin(Champion.Origins.CULTIST); vladimir.addClass(Champion.Classes.SYPHONER);
        Champion wukong = new Champion("wukong"); wukong.addOrigin(Champion.Origins.DIVINE); wukong.addClass(Champion.Classes.VANGUARD);
        Champion xayah = new Champion("xayah"); xayah.addOrigin(Champion.Origins.ELDERWOOD); xayah.addClass(Champion.Classes.EXECUTIONER); xayah.addClass(Champion.Classes.KEEPER);
        Champion yasuo = new Champion("yasuo"); yasuo.addOrigin(Champion.Origins.EXILE); yasuo.addClass(Champion.Classes.DUELIST);
        Champion yone = new Champion("yone"); yone.addOrigin(Champion.Origins.EXILE); yone.addClass(Champion.Classes.ADEPT);
        Champion yuumi = new Champion("yuumi"); yuumi.addOrigin(Champion.Origins.SPIRIT); yuumi.addClass(Champion.Classes.MYSTIC);
        Champion zed = new Champion("zed"); zed.addOrigin(Champion.Origins.NINJA); zed.addClass(Champion.Classes.SLAYER);
        Champion zilean = new Champion("zilean"); zilean.addOrigin(Champion.Origins.CULTIST); zilean.addClass(Champion.Classes.MYSTIC);
        champions = Arrays.asList(aatrox,akali,annie,aurelionSol,azir,brand,braum,chogath,darius,diana,elise,fiora,garen,irelia,
                janna,jarvan,jax,kalista,katarina,kayle,kennen,kindred,leeSin,lulu,maokai,morgana,nasus,nautilus,neeko,nidalee,
                nunu,olaf,ornn,pyke,rakan,samira,sejuani,sett,shen,shyvana,sivir,swain,tahmKench,talon,teemo,tristana,tryndamere,
                twistedFate,veigar,vi,vladimir,wukong,xayah,yasuo,yone,yuumi,zed,zilean);
    }

    void initViews() {
        imageViews = new ImageView[]{aatroxV, akaliV, annieV, aurelionSolV, azirV, brandV, braumV, chogathV, dariusV, dianaV, eliseV, fioraV, garenV, ireliaV,
                jannaV, jarvanV, jaxV, kalistaV, katarinaV, kayleV, kennenV, kindredV, leeSinV, luluV, maokaiV, morganaV, nasusV, nautilusV, neekoV, nidaleeV,
                nunuV, olafV, ornnV, pykeV, rakanV, samiraV, sejuaniV, settV, shenV, shyvanaV, sivirV, swainV, tahmKenchV, talonV, teemoV, tristanaV, tryndamereV,
                twistedFateV, veigarV, viV, vladimirV, wukongV, xayahV, yasuoV, yoneV, yuumiV, zedV, zileanV};
    }

    void initViewsB() {
        imageViewsB = new ImageView[]{aatroxB,akaliB,annieB,aurelionSolB,azirB,brandB,braumB,chogathB,dariusB,dianaB,eliseB,fioraB,garenB,ireliaB,
                jannaB,jarvanB,jaxB,kalistaB,katarinaB,kayleB,kennenB,kindredB,leeSinB,luluB,maokaiB,morganaB,nasusB,nautilusB,neekoB,nidaleeB,
                nunuB,olafB,ornnB,pykeB,rakanB,samiraB,sejuaniB,settB,shenB,shyvanaB,sivirB,swainB,tahmKenchB,talonB,teemoB,tristanaB,tryndamereB,
                twistedFateB,veigarB,viB,vladimirB,wukongB,xayahB,yasuoB,yoneB,yuumiB,zedB,zileanB};
    }

    void initBuffs() {
        imageViewsBuffs = new ImageView[]{cultist,divine,elderwood,enlightened,exile,fortune,ninja,boss,warlord,spirit,fabled,dragonsoul,daredevil,
                adept,assassin,brawler,duelist,emperor,keeper,mage,mystic,sharpshooter,vanguard,syphoner,slayer,executioner,blacksmith};
    }
}