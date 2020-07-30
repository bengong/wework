package wework;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import wework.api.AgentMethods;
import wework.api.ApprovalMethods;
import wework.api.BatchMethods;
import wework.api.CheckinMethods;
import wework.api.DepartmentMethods;
import wework.api.DialMethods;
import wework.api.ExternalContactMethods;
import wework.api.MediaMethods;
import wework.api.MenuMethods;
import wework.api.MessageMethods;
import wework.api.SuiteMethods;
import wework.api.TagMethods;
import wework.api.UserMethods;

@IocBean
public class WeWork {
	@Inject
	public AgentMethods agentMethods;
	@Inject
	public ApprovalMethods approvalMethods;
	@Inject
	public BatchMethods batchMethods;
	@Inject
	public CheckinMethods checkinMethods;
	@Inject
	public DepartmentMethods departmentMethods;
	@Inject
	public DialMethods dialMethods;
	@Inject
	public ExternalContactMethods externalContactMethods;
	@Inject
	public MediaMethods mediaMethods;
	@Inject
	public MenuMethods menuMethods;
	@Inject
	public MessageMethods messageMethods;
	@Inject
	public SuiteMethods suiteMethods;
	@Inject
	public TagMethods tagMethods;
	@Inject
	public UserMethods userMethods;
}
