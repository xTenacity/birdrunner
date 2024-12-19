public class Bird {
    private String name;
    private String[] diet;
    private String color;
    private String endangered;

    //constructor
    public Bird(String name, String[] diet, String color, String endangered) {
        this.name = name;
        this.diet = diet;
        this.color = color;
        this.endangered = endangered;
    }

    //just the name
    public Bird(String name) {
        this.name = name;
        diet = new String[]{"none"};
        color = "uncolored";
        endangered = "unknown";
    }

    //no argument constructor
    public Bird() {
        name = "unnamed";
        diet = new String[]{"none"};
        color = "uncolored";
        endangered = "unknown";
    }



    public void setName(String name) {
        this.name = name;
    }
    public void setDiet(String diet) {
        this.diet = diet.split(", ");
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setEndangered(String endangered) {
        this.endangered = endangered;
    }

    public String getName() {
        return name;
    }
    public String getDiet() {
        String returned = "";
        for (int i = 0; i < diet.length-1; i++) {
            returned += diet[i];
            if (diet.length > 2) returned += ", ";
            else returned += " ";
        }
        if (diet.length > 1) returned += "and ";
        returned += diet[diet.length-1];
        return returned;
    }
    public String getColor() {
        return color;
    }
    public String getEndangered() {
        return endangered;
    }


    @Override
    public String toString() {
        String returned = name + " - Diet of " + getDiet() + ", Colored " + color + " with an endangerment status of " + endangered + ".";
        return returned;
    }
}
