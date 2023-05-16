package entities;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String category;
    private List<String> keyWords;

    private Node parent;

    private List<Node> children;

    public Node(String category){
        this.category=category;
        this.keyWords= new ArrayList<>();
        this.parent = null;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getKeyWords(){
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren(){
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
