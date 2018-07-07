package com.mkyong.rest;
 
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mkyong.rest.HelloWorldService.MyFolder.DataDefinition;
import com.mkyong.rest.HelloWorldService.MyFolder.Field;
 
@Path("/hello")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class HelloWorldService {
 
	/*@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	*/
	@GET
	@Path("/map")
	public XMLFolder getMap() {
 
		MyFolder myFolder = new MyFolder();
		myFolder.folderIndex = "10";
		myFolder.folderName = "folder 1";
		
		Field fi = myFolder.createField();
		fi.fIndex = "f1";
		fi.fName = "Field 1";
		
		Field fi1 = myFolder.createField();
		fi1.fIndex = "f2";
		fi1.fName = "Field 2";
		
		DataDefinition dataDefinition = myFolder.createDataDefinition();
		dataDefinition.index = "DT1";
		dataDefinition.name = "Data Definition 1";
		dataDefinition.fields.put("fi", fi);
		dataDefinition.fields.put("fi1", fi1);
		
		myFolder.dataDefinition = dataDefinition;
		
		XMLFolder xFolder = new XMLFolder();
		xFolder.folderIndex = "1";
		xFolder.folderName = "XML Folder";
		
		return xFolder;
 
	}
	
	
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	class XMLFolder {
		@XmlElement
		String folderIndex;
		@XmlElement String folderName;
		
		public String getFolderIndex() {
			return folderIndex;
		}
		public void setFolderIndex(String folderIndex) {
			this.folderIndex = folderIndex;
		}
		public String getFolderName() {
			return folderName;
		}
		public void setFolderName(String folderName) {
			this.folderName = folderName;
		}
		
		
	}
	
	@XmlRootElement
	@XmlAccessorType(XmlAccessType.NONE)
	class MyFolder{
		
		@XmlRootElement
		public class Field{
			String fIndex;
			String fName;
			public String getfIndex() {
				return fIndex;
			}
			public void setfIndex(String fIndex) {
				this.fIndex = fIndex;
			}
			public String getfName() {
				return fName;
			}
			public void setfName(String fName) {
				this.fName = fName;
			}
			
			
		}
		
		@XmlRootElement
		public class DataDefinition{
			String index;
			String name;
		
			Map<String, Field> fields = new HashMap<String, Field>();
			public String getIndex() {
				return index;
			}
			public void setIndex(String index) {
				this.index = index;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public Map<String, Field> getFields() {
				return fields;
			}
			public void setFields(Map<String, Field> fields) {
				this.fields = fields;
			}
			
			
		}
		
		String folderIndex;
		String folderName;
		DataDefinition dataDefinition;
		
		Field createField(){
			return new Field();
		}
		
		DataDefinition createDataDefinition(){
			return new DataDefinition();
		}

		public String getFolderIndex() {
			return folderIndex;
		}

		public void setFolderIndex(String folderIndex) {
			this.folderIndex = folderIndex;
		}

		public String getFolderName() {
			return folderName;
		}

		public void setFolderName(String folderName) {
			this.folderName = folderName;
		}

		public DataDefinition getDataDefinition() {
			return dataDefinition;
		}

		public void setDataDefinition(DataDefinition dataDefinition) {
			this.dataDefinition = dataDefinition;
		}
		
		
	}
 
}