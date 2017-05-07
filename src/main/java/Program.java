public class Program {

    //this game is an adaptation of a text rpg tutorial written for C#
    //http://www.3dbuzz.com/training/view/xna-volume-1/hyperion-text-adventure-game
    //this game engine allows for pre loaded database games to be played assuming
    //database structure is static

    public static boolean quit = false;

    //main method, runs game
    public static void main(String[] args) {

        //displays message in terminal
        GameManager.ShowTitleScreen();

        //creates new gui instance
        GameEngineGui gui = new GameEngineGui();

        //builds game
        Level.Initialize();

        //places player in starting room
        GameManager.StartGame();

        //links command processor to gui
        CommandProcessor.gui = gui;

        //if quit is true, quits game
       if(quit){
           GameManager.EndGame();
       }


    }
}
