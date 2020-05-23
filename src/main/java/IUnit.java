public interface IUnit {
     void getCost(); // "стоимость" создания
     void getHP(); // получить здоровья
     int setHP(); // установить здоровья
     void getDF(); // получить броню
     int setDF(); // установить броню
     void TakeDanger(int ad); // атака противника

}
