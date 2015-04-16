public class Maze{
    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;
    private int endx, endy;
    private int solutionx, solutiony;
    private Frontier frontier = new Frontier();
    private int [][] solutionSet;
    private int [] solution;
    private int finalCuont;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    public String name(){
	return "yang.william";
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " not found.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx] = c;
	    if(c == 'S'){
		startx = i %maxx;
		starty = i/maxx;
	    }
	    if(c=='E'){
		endx = i%maxx;
		endy = i/maxx;
	    }
	}
	solutionSet = new int[maze.length][maze[0].length];
    }


    public String toString(){
	//do not do the funky character codes, this is used for non-animated printing
	//it is just the string representation of the maze (before or after solving)
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += c;
	    }else{
		ans += c;
	    }
	}
	return ans;
   }

    public String toString(boolean animate){
	if(animate){
	    return clear + go(0, 0) + toString() + "\n" + show;
	}
	else{
	    return toString();
	}
    }

    private String go(int x, int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }

    private class Frontier{
	MyDeque<Coordinate> Frontier = new MyDeque<Coordinate>();
	int mode;

	public Frontier(int mode){
	    this.mode = mode;
	}

	public void add(Coordinate coordinate){
	    frontier.addLast(coordinate);
	}

	public void remove(Coordinate coordinate){
	    if(mode == 0){
		//mode == 0 is bfs
		frontier.removeFirst();
	    }
	    if(mode == 1){
		//mode == 1 is dfs
		frontier.removeFirst();
	    }
	}
    }

    private boolean solve(boolean animate, int mode){

	Frontier rest = new Frontier(mode);
	Point start = new Point(startx,starty);//startx and starty are instance variables in my maze class

	rest.add(start);//put the start into the Frontier 
		
	boolean solved = false;
	while(!solved && rest.hasNext()){
	    if(animate && !solved){
		System.out.println(toString(true));
	    }
	    //get the top
	    Point next = rest.remove();
	    //check if solved
	    if(maze[next.getX()][next.getY()]=='E'){
		//solved!
		solved = true;
		addCoordinatesToSolutionArray(next);

		//my point class has a reference to previous points, so the solution will be determined from the final point

	    }else{
		//not solved, so add neighbors to Frontier and mark the floor with x.
		maze[next.getX()][next.getY()]='x';
		for(Point p : getNeighbors(next)){
		    rest.add(p);
		}

	    }
	}
	return solved;
    }