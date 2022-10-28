import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

import java.awt.event.*;
import java.awt.event.MouseEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import static java.awt.Color.*;

public class Calendar extends JFrame {

    int iterations;
    Border emptyBorder = BorderFactory.createEmptyBorder();

    JPanel eventInputJPanel;

    ImageIcon addEventIcon;


    JLabel dateOfWeekDay;
    JLabel addEventIconJLabel;


    JLabel spaceHolderLabel;
    JLabel todayIcon;

    JButton favouritesBtn;
    JLabel noteLabels;
    JTextField favouritesTF;
    JComboBox favouritesTime;
    JComboBox favouritesDate;
    JLabel akiraBackDrop;
    JPanel dayPanel;
 String comboDate;
 String comboTime;



    Calendar() {
        ImageIcon image = new ImageIcon("pillIcon.jpg");
        super.setIconImage(image.getImage());
        super.setTitle("Calendar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        super.setBounds(-10, 0, 1457, 950);

        setBackgroundImage();
        createCalenderLayout();
        super.add(addCalendarFavouritesPanel());
        super.add(addEventButtonIcon());

        super.setResizable(false);
        super.pack();
        super.repaint();
        super.setVisible(true);
        super.repaint();
        super.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pack();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pack();
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }



    void setBackgroundImage() {
        akiraBackDrop = new JLabel(new ImageIcon("akira3.jpg"));

        super.setContentPane(akiraBackDrop);

        super.getContentPane().setPreferredSize(new Dimension(1460, 1000));

    }

    void createCalenderLayout() {
        final int weekdayValue = LocalDate.now().getDayOfWeek().getValue();
        for (iterations = 1; iterations < 8; iterations++) {
            super.add(
                    addCalenderTextFieldAndButtons(
                            addCalenderNotePanels(
                                    addCalenderDateAndWeekDay(
                                            addCalenderPanelDay(iterations), iterations, weekdayValue)
                            , iterations)
                     ));

        }

        //super.add(addCalendarFavouritesPanel());
        super.setVisible(true);
    }

    JPanel addCalenderPanelDay(int i) {
        dayPanel = new JPanel();
        dayPanel.setBorder(emptyBorder);

        dayPanel.setBackground(new Color(0, 0, 0, 0));

        dayPanel.setLayout(new GridLayout(15, 7));
        dayPanel.setBounds(10 + (i - 1) * 204, 40, 195, 800);
         return dayPanel;
    }



    JPanel addCalenderDateAndWeekDay(JPanel dayPanel, int i, int weekdayValue) {
        spaceHolderLabel = new JLabel();

        todayIcon = new JLabel(new ImageIcon("explosion.jpg"));


        JLabel nameOfWeekDay = new JLabel(String.valueOf((
                LocalDate.now().getDayOfWeek())
                .minus(LocalDate.now().getDayOfWeek().getValue())
                .plus(i)), SwingConstants.CENTER);

        nameOfWeekDay.setOpaque(false);


        dateOfWeekDay = new JLabel(String.valueOf((
                LocalDate.now().
                        minusDays(
                                LocalDate.now().getDayOfWeek().getValue() - (i)))),
                SwingConstants.CENTER);

        nameOfWeekDay.setFont(new Font("Helvetica", Font.BOLD, 25));
        dateOfWeekDay.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 25));
        dateOfWeekDay.setOpaque(false);
        nameOfWeekDay.setBackground(new Color(0, 0, 0, 0));
        dateOfWeekDay.setBackground(new Color(0, 0, 0, 0));

        dayPanel.add(nameOfWeekDay);

        if (i == weekdayValue) {
            dayPanel.add(todayIcon);
        } else dayPanel.add(spaceHolderLabel);
        if (i == 6) {

            dateOfWeekDay.setForeground(BLACK);
            dateOfWeekDay.setBackground(new Color(255,255,255, 90));
            dateOfWeekDay.setOpaque(true);


        }
        if (i < 7) {

            todayIcon.setBorder(new MatteBorder(0, 0, 0, 3, black));
            spaceHolderLabel.setBorder(new MatteBorder(0, 0, 0, 3, black));
            dateOfWeekDay.setBorder(new MatteBorder(0, 0, 0, 3, black));

        }

        dayPanel.add(dateOfWeekDay);


        return dayPanel;
    }

    JPanel addCalenderNotePanels(JPanel dayPanel, int i) {

        for (int j = 0; j < 10; j++) {
            noteLabels = new JLabel();
            if (i < 7) {
                noteLabels.setBorder(new MatteBorder(0, 0, 0, 3, black));



            }


            //JTextField textFieldPrintNote = new JTextField();
            //textFieldPrintNote.setBorder(emptyBorder);
            //textFieldPrintNote.setEditable(false);
            noteLabels.setBackground(new Color(0, 0, 0, 0));
            //textFieldPrintNote.setBackground(new Color(0,0,0,0));
            //           dayPanel.add(textFieldPrintNote);
            noteLabels.revalidate();
            dayPanel.add(noteLabels);
        }
        return dayPanel;
    }


    JPanel addCalenderTextFieldAndButtons(JPanel dayPanel) {
        /*JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JTextField textFieldTakeNote = new JTextField();
        textFieldTakeNote.setHorizontalAlignment(JTextField.CENTER);
        textFieldTakeNote.setBorder(emptyBorder);

        textFieldTakeNote.setBorder(new MatteBorder(3,0,0,0, black));
        textFieldTakeNote.setText("Add an event");

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(0,0,0,0));
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(0,0,0,0));

        addButton.setBorder(emptyBorder);

        deleteButton.setBorder(emptyBorder);
        textFieldAction(textFieldTakeNote);
        dayPanel.add(textFieldTakeNote);
        dayPanel.add(addButton);
        dayPanel.add(deleteButton);

        dayPanel.add(label1);
        dayPanel.add(label2);
*/
        //       addButtonEventListener(dayPanel);
//        deleteButtonEventListener(dayPanel);


        return dayPanel;
    }


    JPanel addCalendarFavouritesPanel() {
        eventInputJPanel = new JPanel();
        eventInputJPanel.add(comboBoxButton());
        eventInputJPanel.add(comboBoxFavouritesTF());

        eventInputJPanel.add(setComboBoxDatum());
        eventInputJPanel.add(setComboBoxKlockslag());
        eventInputJPanel.setLayout(new GridLayout());

        eventInputJPanel.setBorder(new LineBorder(BLACK, 10, true));

        eventInputJPanel.setBounds(50, 800, 700, 40);

        eventInputJPanel.setVisible(false);
        return eventInputJPanel;
    }

    JTextField comboBoxFavouritesTF() {
        favouritesTF = new JTextField();

        favouritesTF.setBackground(BLACK);
        favouritesTF.setForeground(WHITE);
        favouritesTF.setCaretColor(RED);
        favouritesTF.setBorder(emptyBorder);



        favouritesTF.setVisible(true);
        return favouritesTF;
    }


    private JLabel addEventButtonIcon() {

        addEventIcon = new ImageIcon("add_icon.png");

        addEventIconJLabel = new JLabel(addEventIcon);
        addEventIconJLabel.setBounds(80, 790, 60, 60);



        addEventIconJLabel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("WTF");
                addEventIconJLabel.setVisible(false);

                eventInputJPanel.setVisible(true);
                favouritesTF.requestFocus();


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        super.pack();
        super.repaint();
        addEventIconJLabel.setVisible(true);
        return addEventIconJLabel;
    }


    JButton comboBoxButton() {
        JButton favouritesBtn = new JButton("Lägg till händelse");
        favouritesBtn.setBorder(emptyBorder);
        favouritesBtn.setBackground(BLACK);
        favouritesBtn.setFont(new Font("Helvetica", Font.BOLD, 12));
        favouritesBtn.setForeground(RED);

        favouritesBtn.setVisible(true);
        favouritesBtn.addActionListener(e -> {

            String tempTF= favouritesTF.getText() + " " + comboDate + " " +comboTime ;
            favouritesTF.setText("");
            for (Component panel : dayPanel.getComponents()) {
                PopupMenu pM = new PopupMenu(tempTF);
                panel.add(pM);
                panel.repaint();
                panel.setVisible(true);

                        }

eventInputJPanel.setVisible(false);
                addEventIconJLabel.setVisible(true);



        });     return favouritesBtn;


    }

            //eventInputJPanel.setVisible(false);
            //addEventIconJLabel.setVisible(true);



    JComboBox setComboBoxDatum() {
        LocalDate oneMonthExample = LocalDate.now();

        JComboBox<String> favouritesDate = new JComboBox<>();


        for (int i = 0; i < 7; i++) {
            favouritesDate.addItem(String.valueOf(DayOfWeek.MONDAY.plus(i)));




        }
        favouritesDate.addItemListener(e -> comboDate = e.getItem().toString());
        super.pack();
        super.repaint();


        favouritesDate.setForeground(Color.RED);
        favouritesDate.setBackground(BLACK);

        favouritesDate.setFont(new Font("Helvetica", Font.BOLD, 12));
        favouritesDate.setVisible(true);

        return favouritesDate;
    }



    JComboBox setComboBoxKlockslag() {

        JComboBox<String> favouritesTime = new JComboBox<>();


        for (int i = 0; i < 48; i++) {


            if ((LocalTime.MIDNIGHT).plusMinutes(30*i).isBefore(LocalTime.now())){

                favouritesTime.addItem(LocalTime.MIDNIGHT
                        .plusMinutes(30*i)
                        .format(DateTimeFormatter.ofPattern("HH:mm")));
                favouritesTime.setForeground(Color.LIGHT_GRAY);
            }else {

                favouritesTime.addItem(LocalTime.MIDNIGHT
                        .plusMinutes(30*i)
                        .format(DateTimeFormatter.ofPattern("HH:mm")));
                favouritesTime.setForeground(RED);


            }

        }

        favouritesTime.addItemListener( e -> { comboTime = e.getItem().toString(); });


        favouritesTime.setBackground(BLACK);

        favouritesTime.setFont(new Font("Helvetica", Font.BOLD, 12));
        favouritesTime.setVisible(true);
        return favouritesTime;
    }

    void favouritesButtonAction(JButton b, JTextField tF) {
        b.addActionListener(e -> {
            if (tF.getText().length() > 0) {

                tF.setText("");

            }
        });

    }





//   private void addButtonEventListener(JPanel dayPanel, JButton button) {
//
//        button.addActionListener(e -> {
//            for (Component label : dayPanel.getComponents()) {
//                if (label instanceof JTextField && ((JTextField) label).getText().equalsIgnoreCase("")) {
//                    ((JTextField) label).setText(tempPlaceHolder);
//                    tempPlaceHolder = "";
//
//                    break;
//                }
//            }
//        });
//    }

    private void deleteButtonEventListener(JPanel dayPanel, JButton button) {
        button.addActionListener(e -> {
            for (Component label : dayPanel.getComponents()) {
                if (label instanceof JTextField && ((JTextField) label).getText().length() > 0 &&
                        !((JTextField) label).getText().equalsIgnoreCase("Add an event")) {
                    ((JTextField) label).setText("");
                    break;
                }
            }
        });
    }

    boolean bFocusIndicated = false;
    String tempPlaceHolder;

    void textFieldAction(JTextField noteTf) {
        noteTf.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e) {
                if (!bFocusIndicated) {
                    noteTf.setText("");
                    bFocusIndicated = true;

                }
            }

            public void focusLost(FocusEvent e) {
                tempPlaceHolder = noteTf.getText();
                bFocusIndicated = false;
                noteTf.setText("Add an event");
                noteTf.revalidate();
            }


        });

    }
}
