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
    public List<LibroEntity> findBooksFromXML() {
        String valor = "";
        List<LibroEntity> listBooks = new ArrayList<>();
        try {
            File fileXml = new File("CatalogoLibros.xml");

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document docXML = docBuilder.parse(fileXml);
            docXML.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + docXML.getDocumentElement().getNodeName());
            valor = "Elemento raíz: " + docXML.getDocumentElement().getNodeName();

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
                        Node nodeAutor = listAutores.item(j);
                        Element elementAutor = (Element) nodeAutor;
                        autor = elementAutor.getElementsByTagName("autor").item(j).getFirstChild().getNodeValue();
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
                            categoria = categoria+","+elementCategoria.getFirstChild().getNodeValue();
                        }
                    }

                    //FECHA
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
        return listBooks;
    }
}
