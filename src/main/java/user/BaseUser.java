package user;

import java.io.*;
import java.util.Scanner;

public abstract class BaseUser implements IUser {

    protected int level;
    protected int coins;
    protected int levelProgress;
    protected String pathDataUser;

    public BaseUser() {
        pathDataUser = System.getProperty("user.dir") + "/src/main/java/user/dataUser";
        try {
            readDataUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readDataUser() throws IOException {
        File file = new File(pathDataUser);
        FileReader dataFile = new FileReader(file);
        BufferedReader reader = new BufferedReader(dataFile);
        int indexDataTemp = 0;
        int[] dataArray = new int[3];
        String line = reader.readLine();
        while (line!= null) {
            dataArray[indexDataTemp] = Integer.parseInt(line);
            indexDataTemp++;
            line = reader.readLine();
        }
        dataFile.close();
        level = dataArray[0];
        levelProgress = dataArray[1];
        coins = dataArray[2];

    }

    public void setDataUser() {
        FileWriter writerDataUser = null;
        try {
            writerDataUser = new FileWriter(pathDataUser);
            writerDataUser.write(level+"\n"+levelProgress+"\n"+coins);
            writerDataUser.flush();
            writerDataUser.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public int getProgressLevel() {
        return levelProgress;
    }

    @Override
    public void setProgressLevel(int progressLevel) {
        this.levelProgress = progressLevel;
        levelUp();
        setDataUser();
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void levelUp() {
        if (levelProgress >= 100) {
            this.level++;
            levelProgress = 0;
            setDataUser();
        }
    }

    @Override
    public void setCoins(int coins) {
        if (this.coins < 500) {
            this.coins = 500;
        } else {
            this.coins = coins;
        }
        setDataUser();
    }

    @Override
    public int getCoins() {
        return coins;
    }
}
