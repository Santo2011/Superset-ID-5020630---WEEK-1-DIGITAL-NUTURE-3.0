package com.mycompany.factorymethodpatternexample;

public class FactoryMethodPatternExample {

    public static void main(String[] args) {
        // Create a factory for Word documents
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();

        // Create a factory for PDF documents
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();

        // Create a factory for Excel documents
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
    }

    // Document interface
    interface Document {
        void open();
        void save();
    }

    // Concrete document classes
    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a Word document.");
        }

        @Override
        public void save() {
            System.out.println("Saving a Word document.");
        }
    }

    static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening a PDF document.");
        }

        @Override
        public void save() {
            System.out.println("Saving a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening an Excel document.");
        }

        @Override
        public void save() {
            System.out.println("Saving an Excel document.");
        }
    }

    // DocumentFactory abstract class
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // Concrete factories
    static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
}
