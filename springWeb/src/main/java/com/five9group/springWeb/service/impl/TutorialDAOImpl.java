package com.five9group.springWeb.service.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.five9group.springWeb.domain.Tutorial;
import com.five9group.springWeb.service.TutorialDAO;

public class TutorialDAOImpl implements TutorialDAO{
	
	
	 private JdbcTemplate jdbcTemplate;
    
    public TutorialDAOImpl(DataSource dataSource){
    	super();
    	jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    @Transactional
	public void addTutorial(Tutorial tutorial)throws Exception {
		String insertSql = "INSERT INTO tutorial_tbl2" +
                     "(tutorial_title, tutorial_author, tutorial_description)"+
                     "VALUES(?,?,?)";
	jdbcTemplate.update(insertSql,new Object[]{tutorial.getTutorialTitle(),tutorial.getTutorialAuthor(),tutorial.getTutorialDescription()});
		
	}
	@Override
	public Tutorial getTutorialById(Integer Id) throws Exception{
		String query = "select tutorial_id, tutorial_title, tutorial_author,tutorial_description from tutorial_tbl2 where tutorial_id = ?";
        
		Tutorial tutorial = jdbcTemplate.queryForObject(query, new Object[]{Id}, new RowMapper<Tutorial>(){
		        
            public Tutorial mapRow(ResultSet rs, int rowNum)throws SQLException {
                Tutorial tutorial = new Tutorial();
                tutorial.setId(rs.getInt("tutorial_id"));
                tutorial.setTutorialDescription(rs.getString("tutorial_description"));
                tutorial.setTutorialAuthor(rs.getString("tutorial_author"));
                tutorial.setTutorialTitle(rs.getString("tutorial_title"));
                return tutorial;
            }});
		return tutorial;
	}
	
	
	
	@Override
	public List<Tutorial> getListOfTutorials() throws Exception {
		String sql = "select * from tutorial_tbl2";
		
         List<Tutorial> listOfTutorials = jdbcTemplate.query(sql,
     			new BeanPropertyRowMapper<Tutorial>(Tutorial.class));
         List<Tutorial> listOfTutorials2 = jdbcTemplate.query(sql,
        		 new RowMapper<Tutorial>(){
		        
             public Tutorial mapRow(ResultSet rs, int rowNum)throws SQLException {
                 Tutorial tutorial = new Tutorial();
                 tutorial.setId(rs.getInt("tutorial_id"));
                 tutorial.setTutorialDescription(rs.getString("tutorial_description"));
                 tutorial.setTutorialAuthor(rs.getString("tutorial_author"));
                 tutorial.setTutorialTitle(rs.getString("tutorial_title"));
                 return tutorial;
             }});;
        
		return listOfTutorials2;
	}
	
	@Override
	@Transactional 
	public void deleteTutorial(Tutorial tutorial)throws Exception  {
		Integer q=tutorial.getId();
		String deletesql ="DELETE FROM tutorial_tbl2 WHERE tutorial_id ="+ q;
		
		jdbcTemplate.execute(deletesql);
	}
	
	@Override
	@Transactional
	public void updateTutorial(Tutorial tutorial)throws Exception  {
		Integer q = tutorial.getId();
		String updatesql = "UPDATE tutorial_tbl2 "
				+ "SET tutorial_title= '"+ tutorial.getTutorialTitle()+ "', tutorial_author= '"+ tutorial.getTutorialAuthor() 
				+"', tutorial_description= '" + tutorial.getTutorialDescription()+"' "
				+ " WHERE tutorial_id = "+ q;
		
		
		jdbcTemplate.execute(updatesql);
		
	}

	@Override
	public int getLatestInsertedRow() throws Exception {
		String sql ="select max(tutorial_id) from tutorial_tbl2";
		int latestInsertedId = jdbcTemplate.queryForObject(sql, Integer.class);
		return latestInsertedId;

	}
	

	}
	


