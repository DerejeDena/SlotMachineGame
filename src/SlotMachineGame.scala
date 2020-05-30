
import scala.io.StdIn.readLine

object SlotMachineGame {

  // declare variable and initialize
  val r = scala.util.Random   // declare Random variable
  var tokens = 0
  var choice: String = ""
  var line: String = ""
  var earnTokens = 0
  // main function
  def main(args: Array[String]): Unit = {

    // display the Welcome prompt for the user to start the game
    println("==================================")
    println("Welcome to Simple Slot Machine!!")
    println("-------------------------")

    // asking prompt fro the user to input
    println("Please enter tokens in (10 ~ 100) ?")

    // loop for number of first incorrect trial
    for(i<-0 until 5) {

      // read from the user
      line = readLine()

      // patern match of number
      if (line.matches("[+-]?\\d+.?\\d+")){

        // calling Anonymous Functions

        checker(line)
      }
      else
      // prompt for the user input the correct interval
        println("You entered incorrectly. Please enter tokens (10 ~ 100) again?")

    } }
  //    Anonymous Functions with parameter
  val checker = (str:String) => {tokens = str.toInt // passing a value and convert to integer

    // conditional statement for compare the user input
    if (tokens >= 10 && tokens <= 100) {

      // Display how much the user enter
      println(s"You enter $tokens tokens.")
      println("-----------------")

      // loop for the main program
      while ((choice != "N" || choice != "n") && (tokens >= 2))
      {

        // asking input prompt for the user to input
        print(s"You have $tokens tokens. Bet(Y/N)? ")

        // read from the user
        choice = readLine()

        // match statement to check user input
        choice match {

          //1st case
          case x if x == "Y" || x == "y" =>
            // Random numbers and convert to character "A", "B" and "C"
            val slot1 = (r.nextInt(3) + 65).toChar
            val slot2 = (r.nextInt(3) + 65).toChar
            val slot3 = (r.nextInt(3) + 65).toChar

            // Display the random character
            println(s"[$slot1][$slot2][$slot3]")

            // conditional statement to compare the random values
            if (slot1 == 'A' && slot2 == 'A' && slot3 == 'A') {

              // Increment the tokens and the earn tokens by 8
              tokens += 8
              earnTokens += 8

              // display how much they user earn
              println("WOW ~~You earn 8 tokens. ")
            }
            // conditional statement to compare the random value
            else if (slot1 == 'B' && slot2 == 'B' && slot3 == 'B') {

              // increment the tokens and the earn tokens by 4
              tokens += 4
              earnTokens += 4

              // display wining message and  how much the user earn
              println("WOW ~~You earn 4 tokens. ")
            }
            // conditional statement to compare the random value
            else if (slot1 == 'C' && slot2 == 'C' && slot3 == 'C') {

              // increment the tokens and the earn tokens by 2
              tokens += 2
              earnTokens += 2

              // display wining message and how much the user earn
              println("WOW ~~You earn 2 tokens. ")
            }
            else {
              // decrement the tokens and the earn tokens by 2
              tokens -= 2
              earnTokens -= 2

              // display loss message and how much the user loss
              println("BOOOO~~ You lost 2 tokens!  ")
            }
          // 2nd case
          case y
            // conditional statement if the user input 'n' or 'N'
            if y == "N" || y == "n" =>

            // if the earn tokens greater than zero
            if (earnTokens > 0) {

              // Display how much the user earn
              println(s"Thank you for playing!! you earn $earnTokens tokens.")
            }
            else {
              // less than zero
              earnTokens = -earnTokens   // convert negative loss to positive value

              // Display how much the user earn
              println(s"Thank you for playing!! you lost $earnTokens tokens.")
            }
            System.exit(1)  // exit the program when the user input 'n' or 'N'

          // default case
          case _ => println("Incorrect usage. Enter Y or N. ") // display for the user input correctly
            println("-------------------")
        }

        // conditional statement until the user input 'n' or 'N' and if the user out of tokens
      }

      // display for the user when the user lost all input tokens
      println("You do not have enough tokens to play. \n Good-bye!! ")

      System.exit(1)  // exit the program when the user lost all input tokens
    }
    else

    // display to the user to input correctly
      println("You entered incorrectly. Please enter tokens (10 ~ 100) again?")
  }
}


