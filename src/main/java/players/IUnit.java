package players;

public interface IUnit {
     double getCost(); //стоимость
     double getHP(); // получить здоровье
     void setHP(double HP); // установить здоровье
     double getAD(); //получить урон
     void setAD(double AD); // установить урон
     double getDF(); // получить броню
     void setDF(double DF); // установить броню
     void takeDanger(double AD); // атака противника
     void putОn(String wear); //для брони и не только
}
