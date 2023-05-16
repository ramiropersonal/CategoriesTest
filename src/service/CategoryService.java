package service;

import java.util.List;
import java.util.Optional;

import entities.Node;

public interface CategoryService {


    Optional<Node> searchNode(Optional<Node> actual, String category) throws Exception;
    List<String> searchByCategory(Node node,String category) throws Exception;

    int getLevel(Node node);

}
