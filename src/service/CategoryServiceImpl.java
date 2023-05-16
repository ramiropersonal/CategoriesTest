package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entities.Node;

public class CategoryServiceImpl implements CategoryService{

    //obtain Node given category
    @Override
    public Optional<Node> searchNode(Optional<Node> actual, String category) throws Exception {

        Node node = actual.orElseThrow( () ->
                new Exception("Category Not Found"));

        if(node.getCategory()== null || node.getCategory()== null ){
           return Optional.empty();
        }

        if (node.getCategory().equals(category)) {
            return Optional.of(node);
        }

        for (Node child : node.getChildren()) {
            Optional<Node> result = searchNode(Optional.of(child), category);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();
    }

    @Override//give category return keywords
    public List<String> searchByCategory(Node node,String category) throws Exception {
        Optional<Node> nodeCategory = searchNode(Optional.of(getRoot(node)), category);
        List<String> keywords = new ArrayList<>();
        Node nodeCategoryValue = nodeCategory.orElseThrow( () ->
                new Exception("Category Not Found"));

        while (nodeCategoryValue != null) {
            keywords.addAll(nodeCategoryValue.getKeyWords());
            nodeCategoryValue = nodeCategoryValue.getParent();
        }

        return keywords;
    }
    //Obtain Root of Node
    public Node getRoot(Node rootNode) {
        while (rootNode.getParent() != null) {
            rootNode = rootNode.getParent();
        }
        return rootNode;
    }

    @Override//get level begging with root
    public int getLevel(Node node){
        int result=0;
        Node actual = node;

        while(actual.getParent() !=null){
            result++;
            actual = actual.getParent();
        }

        return result;
    }

}
