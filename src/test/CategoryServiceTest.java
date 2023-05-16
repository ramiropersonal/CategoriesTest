package test;

import java.util.List;

import entities.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CategoryService;
import service.CategoryServiceImpl;

public class CategoryServiceTest {

    public CategoryService categoryService;

    @Before
    public void setContext() throws Exception{
        this.categoryService = new CategoryServiceImpl();
    }


    @Test
    public void testObtainKeyword() throws Exception {
        Node actual = new Node("raiz");
        List<String> keywords = List.of("l1","l2");
        actual.setKeyWords(keywords);

        List<String> result = categoryService.searchByCategory(actual,"raiz");
        Assert.assertEquals(keywords,result);
    }

    @Test
    public void testObtainKeywordFailed() throws Exception {
        Node actual = new Node("raiz");
        List<String> keywords = List.of("l1","l2");
        actual.setKeyWords(keywords);
        try{
        List<String> result = categoryService.searchByCategory(actual,"rai");
        }catch (Exception e){
            System.out.println(e);
            Assert.assertTrue(e.toString().contains("Category Not Found"));
        }


    }


    @Test
    public void testGetLevelPadre(){
        Node actual = new Node("raiz");
        Assert.assertEquals(0, categoryService.getLevel(actual));
    }

    @Test
    public void testGetLevelHijo(){
        Node actual = new Node("raiz");
        Node hijo = new Node("category1");
        Node hijo2 = new Node("category2");

        actual.setChildren(List.of(hijo,hijo2));
        hijo.setParent(actual);

        Assert.assertEquals(1, categoryService.getLevel(hijo));
    }

}
