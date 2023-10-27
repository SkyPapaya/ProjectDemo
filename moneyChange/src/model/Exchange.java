package model;

public class Exchange {

        public static void main(String[] args) {
            Human human = new Human();
            human.setAmount(6249);


            Bank bank = new Bank();
            int[] smallChanges = {186, 419, 83, 408};
            bank.setSmallChanges(smallChanges);
            System.out.println(bank.change(human));

        }


}
