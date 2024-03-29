USE [LibraryManagementSystem2]
GO
/****** Object:  Table [dbo].[Books]    Script Date: 6/26/2017 2:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Books](
	[ISBN] [int] NOT NULL,
	[Title] [varchar](50) NOT NULL,
	[AutherName] [varchar](50) NOT NULL,
	[PublisherName] [varchar](50) NOT NULL,
	[Availability] [varchar](50) NOT NULL,
	[enable] [int] NULL,
 CONSTRAINT [PK_Books] PRIMARY KEY CLUSTERED 
(
	[ISBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
