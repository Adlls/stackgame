package user;

public interface IUser {
     int getLevel();
     void levelUp();
     void setCoins(int coins);
     void setProgressLevel(int progressLevel);
     int getProgressLevel();
     int getCoins();
}
