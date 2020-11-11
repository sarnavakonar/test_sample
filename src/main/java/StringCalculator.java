public class StringCalculator {

    public int add(String numbers) {

        int sum = 0;
        StringBuilder negatives= new StringBuilder();
        if(numbers.isBlank())
            return sum;

        if(numbers.startsWith("//")){

            numbers = numbers.substring(2); //   ###\n1###2###3
            String separator = numbers.split("\n")[0]; //    ###
            numbers = numbers.split("\n")[1]; //    1###2###3
            String[] numbersInt = numbers.split(separator);
            for (String s : numbersInt) {
                int number = Integer.parseInt(s);
                if (number < 0) {
                    negatives.append(number).append(",");
                } else if (number <= 1000) {
                    sum += number;
                }
            }
        }
        else {

            numbers = numbers.replaceAll("\n",",");

            String[] numbersInt = numbers.split(",");
            for (String s : numbersInt) {
                int number = Integer.parseInt(s);

                if (number < 0) {
                    negatives.append(number).append(",");
                } else if (number <= 1000) {
                    sum += number;
                }
            }
        }

        if(!negatives.toString().isBlank()){
            throw new RuntimeException("negatives not allowed: "+negatives.substring(0, negatives.length()-1));
        }

        return sum;
    }
}
