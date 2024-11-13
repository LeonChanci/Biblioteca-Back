package com.spring.heroku.biblioteca.service;

import com.spring.heroku.biblioteca.model.LibroEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryXMLService {

    private List<LibroEntity> myListBooks = new ArrayList<>();

    public Document getFileXml() {
        Document docXML = null;
        try {
            File fileXml = new File("CatalogoLibros.xml");
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            docXML = docBuilder.parse(fileXml);
            docXML.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docXML;
    }

    public List<LibroEntity> findBooksFromXML() {
        List<LibroEntity> listBooks = new ArrayList<>();
        try {
            Document docXML = getFileXml();
            NodeList listLibros = docXML.getElementsByTagName("libro");
            for (int i = 0; i < listLibros.getLength(); i++) {
                String id = "";
                String titulo = "";
                String autor = "";
                String descripcion = "";
                String categoria = "";
                String ano = "";

                Node nodeLibro = listLibros.item(i);
                if (nodeLibro.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementLibro = (Element) nodeLibro;

                    //ID LIBRO
                    id = elementLibro.getAttribute("id");

                    //NOMBRE
                    titulo = elementLibro.getElementsByTagName("titulo").item(0).getFirstChild().getNodeValue();

                    //AUTORES
                    NodeList listAutores = elementLibro.getElementsByTagName("autores");
                    for (int j = 0; j < listAutores.getLength(); j++) {
                        Node nodeAutores = listAutores.item(j);
                        Element elementAutores = (Element) nodeAutores;

                        NodeList listAutor = elementAutores.getElementsByTagName("autor");
                        for (int k = 0; k < listAutor.getLength(); k++) {
                            Node nodeAutor = listAutor.item(k);
                            Element elementAutor = (Element) nodeAutor;
                            autor = autor+elementAutor.getFirstChild().getNodeValue()+" - ";
                        }
                        autor = autor.substring(0, autor.length() - 3);
                    }

                    //CONTENIDOS
                    NodeList listContenidos = elementLibro.getElementsByTagName("contenido");
                    for (int j = 0; j < listContenidos.getLength(); j++) {
                        Element elementDescripcion = (Element) listContenidos.item(j);
                        descripcion = elementDescripcion.getElementsByTagName("descripcion").item(j).getFirstChild().getNodeValue();
                    }

                    //CATEGORIAS
                    NodeList listCategorias = elementLibro.getElementsByTagName("categorias");
                    for (int j = 0; j < listCategorias.getLength(); j++) {
                        Node nodeCategorias = listCategorias.item(j);
                        Element elementCategorias = (Element) nodeCategorias;

                        NodeList listCategoria = elementCategorias.getElementsByTagName("categoria");
                        for (int k = 0; k < listCategoria.getLength(); k++) {
                            Node nodeCategoria = listCategoria.item(k);
                            Element elementCategoria = (Element) nodeCategoria;
                            categoria = categoria+elementCategoria.getFirstChild().getNodeValue()+" - ";
                        }
                        categoria = categoria.substring(0, categoria.length() - 3);
                    }

                    //FECHA
                    NodeList listFecha = elementLibro.getElementsByTagName("fechapublicacion");
                    Node nodeFechapublicacion = listFecha.item(0);
                    Element elementFecha = (Element) nodeFechapublicacion;
                    ano = elementFecha.getAttribute("ano");
                }
                LibroEntity newBook = new LibroEntity();
                newBook.setIdLibro(Integer.parseInt(id));
                newBook.setNombre(titulo);
                newBook.setAutor(autor);
                newBook.setDescripcion(descripcion);
                newBook.setCategoria(categoria);
                newBook.setAno(ano);
                listBooks.add(newBook);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        myListBooks = listBooks;
        return listBooks;
    }

    public int findTotalBooksWithMoreOneCategory() {
        int countTotal = 0;
        Document docXML = getFileXml();
        NodeList listLibros = docXML.getElementsByTagName("libro");
        for (int i = 0; i < listLibros.getLength(); i++) {
            Node nodeLibro = listLibros.item(i);
            if (nodeLibro.getNodeType() == Node.ELEMENT_NODE) {
                Element elementLibro = (Element) nodeLibro;
                //CATEGORIAS
                NodeList listCategorias = elementLibro.getElementsByTagName("categorias");
                for (int j = 0; j < listCategorias.getLength(); j++) {
                    int countCategories = 0;
                    Node nodeCategorias = listCategorias.item(j);
                    Element elementCategorias = (Element) nodeCategorias;

                    NodeList listCategoria = elementCategorias.getElementsByTagName("categoria");
                    for (int k = 0; k < listCategoria.getLength(); k++) {
                        Node nodeCategoria = listCategoria.item(k);
                        Element elementCategoria = (Element) nodeCategoria;
                        countCategories ++;
                    }
                    if (countCategories>1) {
                        countTotal ++;
                    }
                }
            }
        }
        return countTotal;
    }

    public Double findPercentageBooksAfterYear2000() {
        double countBooks = 0;
        double countAfterYear = 0;
        double percentage = 0;
        Document docXML = getFileXml();
        NodeList listLibros = docXML.getElementsByTagName("libro");
        for (int i = 0; i < listLibros.getLength(); i++) {
            countBooks ++;
            int ano = 1999;
            Node nodeLibro = listLibros.item(i);
            if (nodeLibro.getNodeType() == Node.ELEMENT_NODE) {
                Element elementLibro = (Element) nodeLibro;

                //FECHA
                NodeList listFecha = elementLibro.getElementsByTagName("fechapublicacion");
                Node nodeFechapublicacion = listFecha.item(0);
                Element elementFecha = (Element) nodeFechapublicacion;
                ano = Integer.parseInt(elementFecha.getAttribute("ano"));

                if (ano > 2000 ) {
                    countAfterYear ++;
                }
            }
        }
        percentage = (countAfterYear/countBooks)*100;
        return percentage;
    }

    public List<LibroEntity> findBooksByAttribute(int anoPublicacion) {
        String anoPub = String.valueOf(anoPublicacion);
        List<LibroEntity> listBooksFilter = new ArrayList<>();
        if (anoPublicacion == 0 || anoPub.length() <4) {
            return findBooksFromXML();
        } else {
            for (LibroEntity book: myListBooks) {
                if(book.getAno().equals(anoPub)){
                    LibroEntity newBook = new LibroEntity();
                    newBook.setIdLibro(book.getIdLibro());
                    newBook.setNombre(book.getNombre());
                    newBook.setAutor(book.getAutor());
                    newBook.setDescripcion(book.getDescripcion());
                    newBook.setCategoria(book.getCategoria());
                    newBook.setAno(book.getAno());
                    listBooksFilter.add(newBook);
                }
            }
        }
        if (listBooksFilter.isEmpty()) {
            listBooksFilter = findBooksFromXML();
        }
        myListBooks = listBooksFilter;
        return listBooksFilter;
    }
}
