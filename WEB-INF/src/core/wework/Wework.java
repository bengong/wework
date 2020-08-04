package wework;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.api.AgentMethods;
import wework.api.ApprovalMethods;
import wework.api.BatchMethods;
import wework.api.CalendarMethods;
import wework.api.CheckinMethods;
import wework.api.CorpMethods;
import wework.api.DepartmentMethods;
import wework.api.DialMethods;
import wework.api.ExternalContactMethods;
import wework.api.MediaMethods;
import wework.api.MeetingroomMethods;
import wework.api.MenuMethods;
import wework.api.MessageMethods;
import wework.api.ScheduleMethods;
import wework.api.SuiteMethods;
import wework.api.TagMethods;
import wework.api.UserMethods;

@IocBean(name="wework")
public class Wework {
	@Inject
	public AgentMethods agent;
	@Inject
	public ApprovalMethods approval;
	@Inject
	public BatchMethods batch;
	@Inject
	public CalendarMethods calendar;
	@Inject
	public CheckinMethods checkin;
	@Inject
	public CorpMethods corp;
	@Inject
	public DepartmentMethods department;
	@Inject
	public DialMethods dial;
	@Inject
	public ExternalContactMethods externalcontact;
	@Inject
	public MediaMethods media;
	@Inject
	public MeetingroomMethods meetingroom;
	@Inject
	public MenuMethods menu;
	@Inject
	public MessageMethods message;
	@Inject
	public ScheduleMethods schedule;
	@Inject
	public SuiteMethods suite;
	@Inject
	public TagMethods tag;
	@Inject
	public UserMethods user;
}
