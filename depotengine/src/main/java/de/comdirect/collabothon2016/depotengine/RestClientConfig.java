package de.comdirect.collabothon2016.depotengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientConfig {

	 	@Bean
	    public RestOperations restOperations(ClientHttpRequestFactory clientHttpRequestFactory) throws Exception {
	        return new RestTemplate(clientHttpRequestFactory);
	    }
	 
	    @Bean
	    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
	        return new HttpComponentsClientHttpRequestFactory(httpClient);
	    }
	 
	    @Bean
	    public HttpClient createHttpClient_AcceptsUntrustedCerts() {
	        HttpClientBuilder b = HttpClientBuilder.create();
	     
	        // setup a Trust Strategy that allows all certificates.
	        //
	        SSLContext sslContext = null;
			try {
				sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				    public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				        return true;
				    }
				}).build();
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KeyStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        b.setSslcontext( sslContext);
	     
	        // don't check Hostnames, either.
	        //      -- use SSLConnectionSocketFactory.getDefaultHostnameVerifier(), if you don't want to weaken
	        HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
	     
	        // here's the special part:
	        //      -- need to create an SSL Socket Factory, to use our weakened "trust strategy";
	        //      -- and create a Registry, to register it.
	        //
	        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
	        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
	                .register("http", PlainConnectionSocketFactory.getSocketFactory())
	                .register("https", sslSocketFactory)
	                .build();
	     
	        // now, we create connection-manager using our Registry.
	        //      -- allows multi-threaded use
	        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager( socketFactoryRegistry);
	        b.setConnectionManager( connMgr);
	     
	        // finally, build the HttpClient;
	        //      -- done!
	        HttpClient client = b.build();
	        return client;
	    }
	    /**
	     * @Value("${keystore.file}") String file,
	                                 @Value("${keystore.pass}") String password
	     * @param file
	     * @param password
	     * @return
	     * @throws Exception
	     */
	   
	    public HttpClient httpClient(@Value("C:/Users/A4595419/store.jks") String file,
	                                 @Value("abc55gkj") String password) throws Exception {
	        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
	        FileInputStream instream = new FileInputStream(new File(file));
	        try {
	            trustStore.load(instream, password.toCharArray());
	        } finally {
	            instream.close();
	        }
	 
	        SSLContext sslcontext =
	                SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();
	        
	        
	        SSLConnectionSocketFactory  factory = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
	        
	        		
	        		
//	        		new SSLConnectionSocketFactory(sslcontext, new X509HostnameVerifier(){
//
//				@Override
//				public boolean verify(String arg0, SSLSession arg1) {
//					// TODO Auto-generated method stub
//					return true;
//				}
//
//				@Override
//				public void verify(String host, SSLSocket ssl) throws IOException {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void verify(String host, X509Certificate cert) throws SSLException {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
//					// TODO Auto-generated method stub
//					
//				}});
	        
	        
	        
	        
//	        SSLConnectionSocketFactory sslsf =
//	                new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1.2"}, null,
//	                		SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); //BROWSER_COMPATIBLE_HOSTNAME_VERIFIER
	        return HttpClients.custom().setSSLSocketFactory(factory).build();
	    }
	 
	    
	    
	    @Bean
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }
}
