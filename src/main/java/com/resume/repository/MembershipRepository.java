package com.resume.repository;

import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.resume.model.Membership;

@Repository
public class MembershipRepository implements IMembershipRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Membership> getMembershipByMembershipId(Long membershipId) {
		// TODO Auto-generated method stub
		String query = "select * from membership where membershipId = " + membershipId;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Membership membership = new Membership();
			membership.setMembershipId(rs.getLong("membershipId"));
			membership.setMembership_no(rs.getLong("membership_no"));
			membership.setMembership_type(rs.getString("membership_type"));
			membership.setMembership_since(rs.getDate("membership_since"));
			membership.setExpiry_date(rs.getDate("expiry_date"));
			membership.setResume_id(rs.getLong("resume_id"));
			return membership;
		});
	}

	@Override
	public List<Membership> getMembershipByResumeId(Long resume_id) {
		// TODO Auto-generated method stub
		String query = "select * from membership where resume_id = " + resume_id;
		return jdbcTemplate.query(query, (rs, rowNum) -> {
			Membership membership = new Membership();
			membership.setMembershipId(rs.getLong("membershipId"));
			membership.setMembership_no(rs.getLong("membership_no"));
			membership.setMembership_type(rs.getString("membership_type"));
			membership.setMembership_since(rs.getDate("membership_since"));
			membership.setExpiry_date(rs.getDate("expiry_date"));
			membership.setResume_id(rs.getLong("resume_id"));
			return membership;
		});
	}

	@Override
	public Long saveMembership(Membership membership) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO membership(membership_no, membership_type, membership_since, expiry_date, resume_id) VALUES(?, ? ,?, ?, ?)";
		Date since = (Date) membership.getMembership_since();
		Date expiry = (Date) membership.getExpiry_date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String membership_since = formatter.format(since);
		String expiry_date = formatter.format(expiry);
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		   jdbcTemplate.update(connection -> {
		       PreparedStatement ps = connection.prepareStatement(query ,new String[] { "membershipId" });
		         
		         	ps.setLong(1, membership.getMembership_no());
		         	ps.setString(2, membership.getMembership_type());
					ps.setString(3, membership_since);
					ps.setString(4, expiry_date);
					ps.setLong(5, membership.getResume_id());
					
		         return ps;
		       }, keyHolder);


		       return  keyHolder.getKey().longValue();
	}

	@Override
	public Integer deleteMembership(Long membershipId) {
		// TODO Auto-generated method stub
		String query = "delete from membership where membershipId = ?";
		return jdbcTemplate.update(query, membershipId);
	}

	@Override
	public Integer deleteMembershipByResumeId(Long resume_id) {
		// TODO Auto-generated method stub
		String query = "delete from membership where resume_id = ?";
		return jdbcTemplate.update(query, resume_id);
	}

	@Override
	public Integer updateMembership(Membership membership, Long membershipId) {
		// TODO Auto-generated method stub
		String query = "update membership set membership_no = ?, membership_type = ?, membership_since = ?, expiry_date = ? where membershipId = " + membershipId;
		Date start = (Date) membership.getMembership_since();
		Date end = (Date) membership.getExpiry_date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String membership_since = formatter.format(start);
		String expiry_date = formatter.format(end);
		return jdbcTemplate.update(query, membership.getMembership_no(),
				membership.getMembership_type(),
				membership_since,
				expiry_date
		
				);
	}

}
