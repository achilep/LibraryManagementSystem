USE [LibraryManagementSystem2]
GO
/****** Object:  Table [dbo].[borrow_detail]    Script Date: 6/26/2017 2:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[borrow_detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Student_id] [int] NOT NULL,
	[Book_ISBN] [int] NOT NULL,
	[Date_from] [date] NOT NULL,
	[Date_to] [date] NOT NULL,
	[Issue_time] [time](7) NULL,
	[Return_time] [time](7) NULL,
	[Actual_Return_Date] [date] NULL,
	[Issued_by] [int] NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_borrow_detail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[borrow_detail]  WITH CHECK ADD FOREIGN KEY([Book_ISBN])
REFERENCES [dbo].[Books] ([ISBN])
GO
ALTER TABLE [dbo].[borrow_detail]  WITH CHECK ADD FOREIGN KEY([Issued_by])
REFERENCES [dbo].[librarian_details] ([id])
GO
ALTER TABLE [dbo].[borrow_detail]  WITH CHECK ADD FOREIGN KEY([Student_id])
REFERENCES [dbo].[student_details] ([Student_id])
GO
