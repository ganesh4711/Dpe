package com.imaginnovate.dpe.contracts;

import com.imaginnovate.dpe.common.EmailAttachment;

public interface IEmailService {

	void sendAsynchronousMail(String to, String subject, String body, boolean isHtml);

	void sendAsynchronousMail(String to, String subject, String body, boolean isHtml,
			EmailAttachment[] attachments);

	void sendDebugEmail(String subject, String body, boolean isHtml);
}
