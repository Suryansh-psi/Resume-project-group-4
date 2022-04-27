//package com.resume.controller;
//
//import java.util.List;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.resume.model.Membership;
//import com.resume.service.IMembershipService;
//
//@RestController
//public class MembershipController {
//	
//	@Autowired
//	private IMembershipService membershipService;
//	
//	@GetMapping("/membership/resume/{resume_id}")
//	public ResponseEntity<List<Membership>> getWorkExpByResumeId(@PathVariable Long resume_id) {
//		return ResponseEntity.ok(membershipService.getMembershipByResumeId(resume_id));
//	}
//
//	@PostMapping("/membership")
//	public ResponseEntity<List<Long>> saveMembership(@RequestBody List<Membership> membership) {
//		return ResponseEntity.ok(membershipService.saveMembership(membership));
//	
//	}
//	
//	@DeleteMapping("membership/{id}")
//	public ResponseEntity<Void> deleteMembership(@PathVariable Long id) {
//		membershipService.deleteMembership(id);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//	}
//	
//	@PutMapping("membership/{membershipId}")
//	public ResponseEntity<Membership> updateMembership(@RequestBody Membership membership, @PathVariable Long membershipId) {
//		Membership response = membershipService.updateMembership(membership, membershipId);
//		return ResponseEntity.ok(response);
//	}
//
//}
