/*
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class CalendarNoteStorage extends JFrame {
    Border emptyBorder = BorderFactory.createEmptyBorder();


   CalendarNoteStorage(){
       ImageIcon image = new ImageIcon("pillIcon.jpg");
       super.setIconImage(image.getImage());
       super.setTitle("Calendar");
       super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       super.setLayout(null);
       JLabel akiraBackDrop = new JLabel(new ImageIcon("akira3.jpg"));

       super.setContentPane(akiraBackDrop);
       //super.getContentPane().setPreferredSize(new Dimension(1000, 600));
       //super.setLayout(new FlowLayout());
       super.setSize(500, 500);
       super.setBounds(200,200, 1000, 400);
       super.setResizable(false);
       super.add(addCalendarFavouritesPanel());

       super.setVisible(true);
   }



    JPanel addCalendarFavouritesPanel(){
        JPanel favouritesPanel = new JPanel();
        favouritesPanel.add(comboBoxButton());
        favouritesPanel.add(comboBoxFavouritesTF());
        favouritesPanel.add(setComboBoxSparadeEvent());
        favouritesPanel.add(setComboBoxDatum());
        favouritesPanel.add(setComboBoxKlockslag());
        favouritesPanel.setLayout(new GridLayout(1,3));
        favouritesPanel.setBounds(0,0,650,20);
        favouritesPanel.setBorder(BorderFactory.createLineBorder(BLACK));
        favouritesButtonAction(comboBoxButton(),comboBoxFavouritesTF(),setComboBoxSparadeEvent());
        favouritesPanel.setVisible(true);
        return favouritesPanel;
    }

    JButton comboBoxButton(){
        JButton favouritesBtn = new JButton("Lägg till händelse");
        favouritesBtn.setBorder(emptyBorder);
        favouritesBtn.setVisible(true);
        favouritesBtn.setBounds(0,0, 140, 20);

        return favouritesBtn;
    }

    JTextField comboBoxFavouritesTF(){
        JTextField favouritesTF = new JTextField();
        favouritesTF.setBorder(emptyBorder);
        favouritesTF.setBounds(0,0, 250, 20);
        favouritesTF.setVisible(true);
        return favouritesTF;
    }

    JComboBox setComboBoxSparadeEvent(){
        JComboBox<String> favourites = new JComboBox<>();
        favourites.addItem("Sparade event");
        favourites.setBounds(0, 0,250,20);
        favourites.setVisible(true);
        favourites.setBackground(WHITE);
        return favourites;
    }
    JComboBox setComboBoxDatum(){
        JComboBox<String> favourites = new JComboBox<>();
        favourites.addItem("Datum");
        favourites.setBounds(0, 0,250,20);
        favourites.setVisible(true);
        favourites.setBackground(WHITE);
        return favourites;
    }
    JComboBox setComboBoxKlockslag(){
        JComboBox<String> favourites = new JComboBox<>();
        favourites.addItem("Tid");
        favourites.setBounds(0, 0,250,20);
        favourites.setVisible(true);
        favourites.setBackground(WHITE);
        return favourites;
    }

    void favouritesButtonAction(JButton b, JTextField tF, JComboBox aL){
        b.addActionListener(e -> {
            if (tF.getText().length() > 0){
                aL.addItem(tF.getText());
                tF.setText("");

            }
        });

    }


}*/
