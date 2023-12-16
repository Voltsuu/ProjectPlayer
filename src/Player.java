public class Player {

    //attributes
    private int numPlayers;
    private int x;
    private int y;
    private int z;
    private int direction;
    private int hp;
    private String name;

    //constructors
    public Player() {
        name = "";
        hp = 20;
        x = 0;
        y = 0;
        z = 0;
        direction = 1;
    }

    public Player(String name, int x, int y, int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        hp = 20;
    }

    public Player(String name, int x, int y, int z, int hp, int direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        if (hp > 0 && hp <= 100) {
            this.hp = hp;
        } else {
            System.out.println("Invalid HP");
        }
        if (direction > 0 || direction <= 6) {
            this.direction = direction;
        } else {
            System.out.println("Invalid direction");
        }
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getHP() {
        return hp;
    }

    public int getDirection() {
        return direction;
    }

    public String toString() {
        String s = ("Number of Players: " + numPlayers + "\nName: " + name + "\nX: " + x + "\nY: " + y + "\nZ: " + z + "\nHP: " + hp + "\nDirection: " + direction);
        return s;
    }

    public void setHp(int hp) {
        if (hp > 0 && hp <= 100) {
            this.hp = hp;
        } else {
            System.out.println("Invalid HP");
        }
    }

    public void setDirection(int direction) {
        if (direction > 0 || direction <= 6) {
            this.direction = direction;
        } else {
            System.out.println("Invalid direction");
        }
    }

    public void move(int direction, int units) {
        if (direction > 0 || direction <= 6) {
            this.direction = direction;
            if (direction == 1) {
                this.x += units;
            } else if (direction == 2) {
                this.x -= units;
            } else if (direction == 3) {
                this.y += units;
            } else if (direction == 4) {
                this.y -= units;
            } else if (direction == 5) {
                this.z += units;
            } else if (direction == 6) {
                this.z -= units;
            }
        } else {
            System.out.println("Invalid direction");
        }
    }

    public void teleport(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void teleport(Player player) {
        this.x = player.getX();
        this.y = player.getY();
        this.z = player.getZ();
    }

    public void attack(Player player, int damage) {
        this.hp += (damage/2);
        player.setHp(player.getHP() - damage);
    }
    //other methods
    public double getDistance(int x, int y, int z) {
        double xDistance = x - getX();
        double yDistance = y - getY();
        double zDistance = z - getZ();
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2) + Math.pow(zDistance, 2));
        return distance;
    }

    public double getDistance(Player player) {
        double xDistance = player.getX() - getX();
        double yDistance = player.getX() - getY();
        double zDistance = player.getX() - getZ();
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2) + Math.pow(zDistance, 2));
        return distance;
    }
}