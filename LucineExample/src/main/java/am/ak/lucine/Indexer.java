package am.ak.lucine;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;

public class Indexer {

    public static void main(String[] args) {
        try {
            Analyzer analyzer = new Analyzer() {
                @Override
                protected TokenStreamComponents createComponents(String fieldName) {
                    Tokenizer tokenizer = new Tokenizer() {
                        @Override
                        public boolean incrementToken() throws IOException {
                            return false;
                        }
                    };
                    return new TokenStreamComponents(tokenizer);
                }
            };
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            FSDirectory directory = FSDirectory.open(new File("").toPath());
            IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
