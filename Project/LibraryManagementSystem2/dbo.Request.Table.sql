USE [LibraryManagementSystem2]
GO
/****** Object:  Table [dbo].[Request]    Script Date: 6/26/2017 2:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Student_id] [int] NOT NULL,
	[BookISBN] [int] NOT NULL,
	[Date] [date] NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[visible] [int] NOT NULL,
 CONSTRAINT [PK_Request] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([BookISBN])
REFERENCES [dbo].[Books] ([ISBN])
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([Student_id])
REFERENCES [dbo].[student_details] ([Student_id])
GO
