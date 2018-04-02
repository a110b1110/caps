package article.notice.model;

public class NoticeContent {

   private Integer postId;
   private String content;
   private String origin;
   private String stored;
   private long fileSize;
   private String fileExt;

   public NoticeContent(Integer postId, String content, String origin, String stored,
         long size, String ext) {
      this.postId = postId;
      this.content = content;
      this.origin = origin;
      this.stored = stored;
      this.fileSize = size;
      this.fileExt = ext;
   }

   public Integer getPostId() {
      return postId;
   }

   public String getContent() {
      return content;
   }

   public String getOrigin() {
      return origin;
   }

   public String getStored() {
      return stored;
   }

   public Long getFileSize() {
      return fileSize;
   }

   public String getFileExt() {
      return fileExt;
   }
}