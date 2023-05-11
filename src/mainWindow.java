import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;


public class mainWindow extends JFrame {
    //создание не меняющихся элементов приложения
    private JPanel mainPanel;
    private JPanel firstPanel;
    private JTabbedPane gamePanel;
    private JPanel rulePanel;

    private JLabel mainFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/mainFon.jpg"));
    private JLabel[] gameFon = new JLabel[20];
    private JLabel ruleFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/rule_fon.jpg"));


    private ImageIcon playIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/play.png");
    private ImageIcon ruleIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/rules.png");
    private ImageIcon exitIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/exit.png");
    private ImageIcon replyIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/reply.png");
    private ImageIcon continueIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/continue.png");
    private ImageIcon correctIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/correct2.png");
    private ImageIcon xIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/x2.png");
    private ImageIcon backIcon = new ImageIcon("/home/wakhram/projects/quizProject/src/back.png");

    private JLabel zero_six;
    private JLabel seven_thirteen;
    private JLabel fourteen_nineteen;
    private JLabel twenty;

    private int i, j, count;
    private int life = 3;


    mainWindow(){
        /*------------------*/
        super("Викторина по Java");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,800);
        /*------------------*/
        mainPanel = new JPanel(new BorderLayout());
        /*------------------*/
//        Первое окно или окно входа в игру
        firstPanel = new JPanel(new BorderLayout());
        firstPanel.add(mainFon);
        mainFon.setLayout(null);

        JButton play = new JButton("Играть", playIcon);
        play.setHorizontalTextPosition(SwingConstants.LEFT);
        play.setBounds(35,280,180,50);
        play.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.add(gamePanel);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        JButton rules = new JButton("Правила игры", ruleIcon);
        rules.setHorizontalTextPosition(SwingConstants.LEFT);
        rules.setBounds(35,360,180,50);
        rules.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.add(rulePanel, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        JButton exit = new JButton("Выйти", exitIcon);
        exit.setHorizontalTextPosition(SwingConstants.LEFT);


        exit.setBounds(35,440,180,50);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        mainFon.add(play);
        mainFon.add(rules);
        mainFon.add(exit);


        mainPanel.add(firstPanel);
    /*------------------*/
//        Окно с правилой
        rulePanel = new JPanel(new BorderLayout());
        rulePanel.add(ruleFon);
        ruleFon.setLayout(null);

        JButton back = new JButton("Назад", backIcon);
        back.setHorizontalTextPosition(SwingConstants.LEFT);
        back.setBounds(25,25,120,50);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.add(firstPanel, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        JLabel rule_text = new JLabel("<html><h1>Правила викторины</h1><br>"+"" +
                "<h3>В этой викторине вас ждут 20 вопросов.<br>"+
                "Каждый по 4 ответа на выбор, но правильный лишь один.<br>" +
                "Если вы ошиблись - для первого раза ничего страшного.<br>" +
                "Но если вы ошиблись 3 раза, то игра для вас будет окончена поражением)<br>" +
                "Выиграть вы можете только в случае набора 20 правильных ответов.<br>" +
                "1. Можно выбрать лишь один вариант ответа.После выбора ответа необходимо нажимать на кнопку 'Ответить'. В противном случае, ваш ответ не будет засчитан<br>" +
                "2. Отвечать на вопросы надо строго по порядку, не переходя из одного конца в другой.<br>" +
                "3. После того, как нажмёте на кнопку 'Продолжить', возможность вернуться к вопросу исчезнет.<br></h3>" +
                "<h2>Удачных вам голодных игр!</h2>" +
                "</html>");
        rule_text.setForeground(Color.WHITE);
        rule_text.setBounds(100,200,600,400);

        ruleFon.add(back);
        ruleFon.add(rule_text);

        /*------------------*/
//        Вопросы, их ответы и варианты, всего 20 вопросов
        HashMap<Integer, String> questions = new HashMap<>();
        questions.put(1,"<html><h1>Сколько ключевых слов зарезервировано языком</h1></html");
        questions.put(2,"<html><h1>Из каких символов может состоять имя переменной (корректный идентификатор)?</h1></html>");
        questions.put(3,"<html><h1>На какие основные группы можно поделить типы данных?</h1></html>");
        questions.put(4,"<html><h1>В Java существует 8 примитивных типов.Укажите неверный ответ:</h1></html>");
        questions.put(5,"<html><h1>Какими значениями инициализируются переменные с типом целых чисел по умолчанию?</h1></html>");
        questions.put(6,"<html><h1>Какие логические операции и операторы вы знаете?</h1></html>");
        questions.put(7,"<html><h1>Какой оператор используется для немедленной остановки цикла?</h1></html>");
        questions.put(8,"<html><h1>Как называется код между фигурными скобками?</h1></html>");
        questions.put(9,"<html><h1>В чем разница между char и Character?</h1></html>");
        questions.put(10,"<html><h1>Какие из этих операторов можно использовать для объединения двух или более объектов String?</h1></html>");
        questions.put(11,"<html><h1>От какого класса наследуют все классы Java?</h1></html>");
        questions.put(12,"<html><h1>Что такое класс в Java?</h1</html>");
        questions.put(13,"<html><h1>Как объявить класс в коде?</h1</html>");
        questions.put(14,"<html><h1>Для чего используется оператор NEW?</h1></html>");
        questions.put(15,"<html><h1>Что означает ключевое слово extends?</h1></html>");
        questions.put(16,"<html><h1>Что означает перегрузка метода в Java (overload).</h1></html>");
        questions.put(17,"<html><h1>Что означает переопределение метода в Java (override).</h1></html>");
        questions.put(18,"<html><h1>Как вызвать static-метод внутри обычного?</h1></html>");
        questions.put(19,"<html><h1>Что вернет метод, объявленный следующим образом: public static int getAmount()</h1></html>");
        questions.put(20,"<html><h1>Что общего у всех элементов массива?</h1></html>");

        HashMap<Integer, String> answers = new HashMap<>();
        answers.put(1,"<html><h3>50</h3></html>");
        answers.put(2,"<html><h3>Заглавные и строчные буквы, цифры, нижняя подчеркивание</h3></html>");
        answers.put(3,"<html><h3>Целые числа, числа с плавающей точкой, символы, логический</h3></html>");
        answers.put(4,"<html><h3>Bit</h3></html>");
        answers.put(5,"<html><h3>0</h3></html>");
        answers.put(6,"<html><h3>&&, ||, !, ^, |, &</h3></html>");
        answers.put(7,"<html><h3>Break</h3></html>");
        answers.put(8,"<html><h3>блок</h3></html>");
        answers.put(9,"<html><h3>char является примитивным типом, а Character классом.</h3></html>");
        answers.put(10,"<html><h3>+</h3></html>");
        answers.put(11,"<html><h3>Object</h3></html>");
        answers.put(12,"<html><h3>Базовый элемент объектно-ориентированного программирования в языке Java.</h3></html>");
        answers.put(13,"<html><h3>class MyClass {}</h3></html>");
        answers.put(14,"<html><h3>Для создания экземпляра класса.</h3></html>");
        answers.put(15,"<html><h3>Что данный класс наследуется от другого</h3></html>");
        answers.put(16,"<html><h3>Несколько методов с одинаковым названием, но разным набором параметров.</h3></html>");
        answers.put(17,"<html><h3>Изменение поведения метода класса относительно родительского.</h3></html>");
        answers.put(18,"<html><h3>Можно, ничего дополнительно делать не надо.</h3></html>");
        answers.put(19,"<html><h3>Вернет целочисленное значение.</h3></html>");
        answers.put(20,"<html><h3>Их тип данных</h3></html>");

        String[][] answers_option = {
                {"<html><h3>50</h3></html>","<html><h3>48</h3></html>","<html><h3>55</h3></html>","<html><h3>45</h3></html>"},
                {"<html><h3>Строчные буквы, цифры</h3></html>","<html><h3>Заглавные и строчные буквы, цифры, нижняя подчеркивание</h3></html>",
                        "<html><h3>Заглавные буквы, нижняя подчеркивание</h3></html>","<html><h3>Цифры, заглавные буквы</h3></html>"},
                {"<html><h3>Числа, логическое, символы</h3></html>","<html><h3>Целые числа, символы, строки</h3></html>",
                        "<html><h3>Целые числа, числа с плавающей точкой, символы</h3></html>","<html><h3>Целые числа, числа с плавающей точкой, символы, логический</h3></html>"},
                {"<html><h3>Short</h3></html>","<html><h3>Boolean</h3></html>","<html><h3>Float</h3></html>","<html><h3>Bit</h3></html>"},
                {"<html><h3>0</h3></html>","<html><h3>Null</h3></html>","<html><h3>1</h3></html>","<html><h3>Рандомное число</h3></html>"},
                {"<html><h3>&&, ||, !, ^, |, &</h3></html>","<html><h3>&, |, !</h3></html>","<html><h3>&&, ||, ^, !</h3></html>","<html><h3>&, |, &&, ||</h3></html>"},
                {"<html><h3>Stop</h3></html>","<html><h3>Break</h3></html>","<html><h3>Continue</h3></html>","<html><h3>Exit</h3></html>"},
                {"<html><h3>функция</h3></html>","<html><h3>секция</h3></html>","<html><h3>тело</h3></html>","<html><h3>блок</h3></html>"},
                {"<html><h3>char является примитивным типом, а Character классом.</h3></html>","<html><h3>нет разницы, они оба примитивные типы.</h3></html>",
                        "<html><h3>char является классом, а Character примитивным типом.</h3></html>","<html><h3>нет разницы, они оба классы.</h3></html>"},
                {"<html><h3>*=</h3></html>","<html><h3>+</h3></html>","<html><h3>+=</h3></html>","<html><h3>*</h3></html>"},
                {"<html><h3>Object</h3></html>","<html><h3>List</h3></html>","<html><h3>Runtime</h3></html>","<html><h3>Collection</h3></html>"},
                {"<html><h3>Уровень сложности программы. Все операторы делятся на классы в зависимости от сложности их использования.</h3></html>",
                        "<html><h3>Базовый элемент объектно-ориентированного программирования в языке Java.</h3></html>",
                        "<html><h3>Просто одно из возможных названий переменной.</h3></html>",
                        "<html><h3>Такое понятие есть только в C++, в Java такого понятия нет.</h3></html>"},
                {"<html><h3>class MyClass {}</h3></html>","<html><h3>new class MyClass {}</h3></html>","<html><h3>select * from class MyClass {}</h3></html>","<html><h3>MyClass extends class {}</h3></html>"},
                {"<html><h3>Это антагонист оператора OLD.</h3></html>","<html><h3>Для создания экземпляра класса.</h3></html>",
                        "<html><h3>Для объявления нового класса.</h3></html>","<html><h3>Для создания новой переменной.</h3></html>"},
                {"<html><h3>Что данный класс наследуется от другого</h3></html>","<html><h3>Что это дополнительный модуль класса, который расширяет его свойства.</h3></html>",
                        "<html><h3>Что два класса делают одно и то же.</h3></html>","<html><h3>Что это самый большой класс в программе.</h3></html>"},
                {"<html><h3>Изменение поведения метода класса относительно родительского.</h3></html>","<html><h3>Изменение поведения метода класса относительно дочернего.</h3></html>",
                        "<html><h3>Несколько методов с одинаковым названием, но разным набором параметров.</h3></html>","<html><h3>Несколько разных классов с одинаковым методом.</h3></html>"},
                {"<html><h3>Изменение поведения метода класса относительно родительского.</h3></html>","<html><h3>Изменение поведения метода класса относительно дочернего.</h3></html>",
                        "<html><h3>Несколько методов с одинаковым названием, но разным набором параметров.</h3></html>","<html><h3>Несколько разных классов с одинаковым методом.</h3></html>"},
                {"<html><h3>Никак, static-метод можно вызвать только от объекта класса.</h3></html>","<html><h3>Можно, надо перед этим перегрузить обычный метод класса.</h3></html>",
                        "<html><h3>Можно, надо перед этим переопределить обычный метод класса.</h3></html>","<html><h3>Можно, ничего дополнительно делать не надо.</h3></html>"},
                {"<html><h3>Не ясно, надо смотреть код метода.</h3></html>","<html><h3>Вернет static-поле класса.</h3></html>",
                        "<html><h3>Вернет ссылку на объект класса this.</h3></html>","<html><h3>Вернет целочисленное значение.</h3></html>"},
                {"<html><h3>Их размер</h3></html>","<html><h3>Их названия</h3></html>","<html><h3>Их адрес в памяти</h3></html>","<html><h3>Их тип данных</h3></html>"},
        };
        /*------------------*/
//        окно с игрой
        UIManager.put("TabbedPane.contentOpaque", false);
        gamePanel = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);
        JPanel[] qPanel = new JPanel[20];
        for (i = 0; i < 20; i++) {
            gameFon[i] = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/game_fon.jpg"));
            qPanel[i] = new JPanel(new BorderLayout());
            qPanel[i].add(gameFon[i]);
            gameFon[i].setLayout(null);
        }

        JLabel[] qS = new JLabel[20];
        ButtonGroup bg;

        for (i = 0; i < 20; i++) {
            qS[i] = new JLabel();
            qS[i].setText(questions.get(i+1));
            qS[i].setForeground(Color.WHITE);
            qS[i].setBounds(150,0,600,250);
            gameFon[i].add(qS[i]);

            JLabel life_label = new JLabel("<html><h3>Шанс на победу : </h3></html>");
            life_label.setBounds(100, 650,200,50);
            life_label.setForeground(Color.WHITE);

            JButton reply = new JButton("Ответить", replyIcon);
            reply.setHorizontalTextPosition(SwingConstants.LEFT);
            reply.setBounds(350,650,200,50);

            JButton continueB = new JButton("Продолжить", continueIcon);
            continueB.setHorizontalTextPosition(SwingConstants.LEFT);
            continueB.setBounds(600,650,200,50);
            continueB.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (gamePanel.getSelectedIndex() < 19) {
                        gamePanel.setSelectedIndex(gamePanel.getSelectedIndex()+1);
                        gamePanel.setEnabledAt((gamePanel.getSelectedIndex()-1), false);    



                    }
                    else if (gamePanel.getSelectedIndex() == 19) {
                        JLabel resultFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/20.jpg"));
                        JPanel result = new JPanel(new BorderLayout());
                        result.add(resultFon);
                        resultFon.setLayout(null);

                        twenty = new JLabel("<html><h3>Хороооооооош, вот он результат настоящего программиста Java. Мы знали, что у тебя получится пройти данную викторину.<br>" +
                                "Ты - большой молодец! Но так как ты уже прошел викторину и знаешь все ответы, она потеряла для тебя смысл.<br>" +
                                "Не забывай нас, как то, что мотивировало тебя изучать язык Java.<br></h3>" +
                                "<h2>Удачи в дальнейшем и присоединяйся к нашим будущим разработкам)</h2></html>");
                        twenty.setBounds(100,200,600,300);
                        twenty.setForeground(Color.WHITE);


                        resultFon.add(twenty);
                        exit.setLocation(410,650);
                        resultFon.add(exit);

                        mainPanel.removeAll();
                        mainPanel.add(result);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                }
            });


            gameFon[i].add(life_label);
            gameFon[i].add(reply);
            gameFon[i].add(continueB);
            bg = new ButtonGroup();

            int k = 0;
            JRadioButton[] answerB = new JRadioButton[4];
            for (j = 0; j < 4; j++) {
                answerB[j] = new JRadioButton(answers_option[i][j]);
                answerB[j].setBounds(150, (150+k),450,100);
                answerB[j].setOpaque(false);
                answerB[j].setForeground(Color.WHITE);
                answerB[j].addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        String person_answer = ((JRadioButton) e.getItem()).getText();
                            reply.addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent e) {
                                    for (int z = 0; z < 4; z++) {
                                        if (person_answer == answerB[z].getText()) {
                                            if (person_answer == answers.get(gamePanel.getSelectedIndex() + 1)) {
                                                count += 1;

                                                life_label.setText("<html><h3>Шанс на победу : " + life + "</h3></html>");

                                                answerB[z].setIcon(correctIcon);
                                                answerB[z].setHorizontalTextPosition(SwingConstants.LEFT);
                                                answerB[z].setForeground(new Color(127, 255, 0));

                                                if (gamePanel.getSelectedIndex() == 19 && life < 3) {
                                                    JLabel resultFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/14-19.jpg"));
                                                    JPanel result = new JPanel(new BorderLayout());
                                                    result.add(resultFon);
                                                    resultFon.setLayout(null);

                                                    fourteen_nineteen = new JLabel("<html><h3>Воооооооу, вот это результат. Он уже выше, чем у 90% прошедших эту викторину.<br>" +
                                                            "Но ты немного не дотягиваешь до победных 20 баллов. Ты набрал - " + count +
                                                            "<br>Поднажми немного и совсем скоро у тебя все получится. Главное, не останавливайся.<br></h3>" +
                                                            "<h2>Удачи!</h2></html>");
                                                    fourteen_nineteen.setBounds(100, 200, 600, 300);
                                                    fourteen_nineteen.setForeground(Color.WHITE);

                                                    exit.setLocation(410, 650);
                                                    resultFon.add(exit);
                                                    resultFon.add(fourteen_nineteen);

                                                    mainPanel.removeAll();
                                                    mainPanel.add(result);
                                                    mainPanel.revalidate();
                                                    mainPanel.repaint();

                                                }
                                            }
                                            else {
                                                life--;
                                                life_label.setText("<html><h3>Шанс на победу : " + life + "</h3></html>");

                                                answerB[z].setIcon(xIcon);
                                                answerB[z].setHorizontalTextPosition(SwingConstants.LEFT);
                                                answerB[z].setForeground(new Color(255, 0, 0));

                                                if (gamePanel.getSelectedIndex() == 19 && life > 0) {
                                                    JLabel resultFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/14-19.jpg"));
                                                    JPanel result = new JPanel(new BorderLayout());
                                                    result.add(resultFon);
                                                    resultFon.setLayout(null);

                                                    fourteen_nineteen = new JLabel("<html><h3>Воооооооу, вот это результат. Он уже выше, чем у 90% прошедших эту викторину.<br>" +
                                                            "Но ты немного не дотягиваешь до победных 20 баллов. Ты набрал - " + count +
                                                            "<br>Поднажми немного и совсем скоро у тебя все получится. Главное, не останавливайся.<br></h3>" +
                                                            "<h2>Удачи!</h2></html>");
                                                    fourteen_nineteen.setBounds(100, 200, 600, 300);
                                                    fourteen_nineteen.setForeground(Color.WHITE);

                                                    exit.setLocation(410, 650);
                                                    resultFon.add(exit);
                                                    resultFon.add(fourteen_nineteen);

                                                    mainPanel.removeAll();
                                                    mainPanel.add(result);
                                                    mainPanel.revalidate();
                                                    mainPanel.repaint();

                                                }
                                                if (life == 0) {
                                                    if (count >= 0 && count <= 6) {
                                                        JLabel resultFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/0-6.jpg"));
                                                        JPanel result = new JPanel(new BorderLayout());
                                                        result.add(resultFon);
                                                        resultFon.setLayout(null);


                                                        zero_six = new JLabel("<html><h3>Оооооооу, результат не так высок, как мог бы быть.<br>" +
                                                                "Ты набрал - " + count +
                                                                "<br>Попробуй пройти викторину еще раз и ознакомься с Java тщательнее.<h3><br> " +
                                                                "<h2>Удачи тебе в изучении нового!</h2></html>");
                                                        zero_six.setBounds(100, 200, 600, 300);
                                                        zero_six.setForeground(Color.WHITE);

                                                        exit.setLocation(410, 650);
                                                        resultFon.add(exit);
                                                        resultFon.add(zero_six);


                                                        mainPanel.removeAll();
                                                        mainPanel.add(result);
                                                        mainPanel.revalidate();
                                                        mainPanel.repaint();
                                                    } else if (count >= 7 && count <= 13) {
                                                        JLabel resultFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/7-13.jpg"));
                                                        JPanel result = new JPanel(new BorderLayout());
                                                        result.add(resultFon);
                                                        resultFon.setLayout(null);


                                                        seven_thirteen = new JLabel("<html><h3>Йоооооооу, результат такой же как у 70% прошедших эту викторину.<br>" +
                                                                "Ты набрал - " + count +
                                                                "<br>Ты хорошо идешь, но главное не останавливайся и продолжай изучать язык программирования Java.<br>" +
                                                                "Еще немного и ты сможешь пройти эту викторину.<br></h3>" +
                                                                "<h2>Удачи!</h2><html>");
                                                        seven_thirteen.setBounds(100, 200, 600, 300);
                                                        seven_thirteen.setForeground(Color.WHITE);


                                                        exit.setLocation(410, 650);
                                                        resultFon.add(exit);
                                                        resultFon.add(seven_thirteen);

                                                        mainPanel.removeAll();
                                                        mainPanel.add(result);
                                                        mainPanel.revalidate();
                                                        mainPanel.repaint();
                                                    } else if (count >= 14 && count <= 19) {
                                                        JLabel resultFon = new JLabel(new ImageIcon("/home/wakhram/projects/quizProject/src/14-19.jpg"));
                                                        JPanel result = new JPanel(new BorderLayout());
                                                        result.add(resultFon);
                                                        resultFon.setLayout(null);

                                                        fourteen_nineteen = new JLabel("<html><h3>Воооооооу, вот это результат. Он уже выше, чем у 90% прошедших эту викторину.<br>" +
                                                                "Но ты немного не дотягиваешь до победных 20 баллов. Ты набрал - " + count +
                                                                "<br>Поднажми немного и совсем скоро у тебя все получится. Главное, не останавливайся.<br></h3>" +
                                                                "<h2>Удачи!</h2></html>");
                                                        fourteen_nineteen.setBounds(100, 200, 600, 300);
                                                        fourteen_nineteen.setForeground(Color.WHITE);

                                                        exit.setLocation(410, 650);
                                                        resultFon.add(exit);
                                                        resultFon.add(fourteen_nineteen);

                                                        mainPanel.removeAll();
                                                        mainPanel.add(result);
                                                        mainPanel.revalidate();
                                                        mainPanel.repaint();

                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            answerB[z].setEnabled(false);
                                            continue;
                                        }
                                    }
                                }
                            });
                    }
                });

                k += 100;
                bg.add(answerB[j]);
                gameFon[i].add(answerB[j]);
            }
            gamePanel.addTab("Вопрос - " + (i+1), qPanel[i]);
        }
        /*------------------*/
        setContentPane(mainPanel);
        /*------------------*/
    }
}






