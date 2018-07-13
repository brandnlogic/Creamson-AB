package com.bnl.creamson.ptm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnl.creamson.ptm.application.ApplicationMessage;
import com.bnl.creamson.ptm.dto.MeetingDetlDto;
import com.bnl.creamson.ptm.dto.Message;
import com.bnl.creamson.ptm.dto.ResponseDto;
import com.bnl.creamson.ptm.enums.FindByCriteria;
import com.bnl.creamson.ptm.service.MeetingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * It request 4 information in header.
 * 
 * 	1. User ID- who is going to create the meeting request
 *  2. request is made from which application
 */

@RestController
@RequestMapping(path="/meetingschedule")
@Api(value="Schedule Meeting",tags={"You can schedule meeting with parents, teacher and institute"})
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	
	@ApiOperation(value="This api help to search meeting schedule.", consumes="application/json",
					produces="application/json", response= ResponseDto.class)
	
	@PostMapping(path="/searchSchedule/{findBy}", consumes={"application/json"} , produces={"application/json"})
	public ResponseEntity<ResponseDto<List<MeetingDetlDto>>> serachMeetingSchedule(@RequestHeader("Request-User") String userName, 
										@RequestHeader("Request-Application") String applicationName,
										@RequestBody MeetingDetlDto meetingDtl,
										@PathVariable("findBy") FindByCriteria findBy){
		List<ApplicationMessage> message = new ArrayList<ApplicationMessage>();
		List<MeetingDetlDto> searchMeetingDetails = meetingService.searchMeetingDetails(meetingDtl, userName, message);
		
		ResponseDto<List<MeetingDetlDto>> responseDto = new ResponseDto<List<MeetingDetlDto>>();
		
		responseDto.setMessage(message.stream()
				.filter(Objects::nonNull)
				.map(e-> new Message(e.getMessageType(), e.getMessageCode(), e.getMessage())).collect(Collectors.toList()));
		
		responseDto.setPayload(searchMeetingDetails);
		
		return new ResponseEntity<ResponseDto<List<MeetingDetlDto>>>(responseDto, HttpStatus.OK);
	}
	
	@ApiOperation(value="This api help to create meeting schedule.", consumes="application/json",
			produces="application/json", response=ResponseDto.class)
	@PutMapping(path="/createSchedule", consumes={"application/json"} , produces={"application/json"} )
	public ResponseEntity<ResponseDto<MeetingDetlDto>> createMeetingSchedule(@RequestHeader("Request-User") String userName, 
										@RequestHeader("Request-Application") String applicationName,
										@Valid @RequestBody MeetingDetlDto meetingDtl){
		List<ApplicationMessage> message = new ArrayList<ApplicationMessage>();
		MeetingDetlDto saveMeetingDetails = meetingService.saveMeetingDetails(meetingDtl, userName, message);
		
		ResponseDto<MeetingDetlDto> responseDto = new ResponseDto<MeetingDetlDto>();
		
		responseDto.setMessage(message.stream()
				.filter(Objects::nonNull)
				.map(e-> new Message(e.getMessageType(), e.getMessageCode(), e.getMessage())).collect(Collectors.toList()));
		
		responseDto.setPayload(saveMeetingDetails);
		
		return new ResponseEntity<ResponseDto<MeetingDetlDto>>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping(value="/search")
	public String getService(){
		return "hello";
	}
	
}
