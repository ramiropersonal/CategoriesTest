package test;

import java.util.List;

import entities.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CategoryService;
import service.CategoryServiceImpl;

public class CategoryTest {

    public CategoryService categoryService;
    @Before
    public void setContext() throws Exception {
        this.categoryService = new CategoryServiceImpl();
    }


    @Test
    public void testCreationNode(){
        Node raiz= new Node("raiz");

        Node category1 = new Node("category1");
        category1.setParent(raiz);
        Node category2 = new Node("category2");
        category1.setParent(raiz);

        Assert.assertEquals("raiz",category1.getParent().getCategory());

    }

    @Test
    public void testCreationNodeFailed(){
        Node raiz= new Node("rai");

        Node category1 = new Node("category1");
        category1.setParent(raiz);
        Node category2 = new Node("category2");
        category1.setParent(raiz);

        Assert.assertNotEquals("raiz",category1.getParent().getCategory());

    }

    @Test
    public void testKeywords(){
        Node raiz= new Node("raiz");
        List<String> keywords = List.of("l1","l2");
        raiz.setKeyWords(keywords);
        Assert.assertEquals(keywords,raiz.getKeyWords());

    }

    @Test
    public void testKeywordsFailed(){
        Node raiz= new Node("raiz");
        List<String> keywords = List.of("l1","l2");
        raiz.setKeyWords(keywords);
        Assert.assertNotEquals(List.of("l3"),raiz.getKeyWords());

    }

}
