package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    /** 
     * Call the getAllImages() method in the Repository and obtain a List of all the images in the database
     * @return
     */
    public List<Image> getAllImages() {
        return imageRepository.getAllImages();
    }


    /**
     * The method calls the createImage() method in the Repository and passes the image to be persisted in the database
     * @param image
     */
    public void uploadImage(Image image) {
        imageRepository.uploadImage(image);
    }


    /**
     * The method calls the getImageByTitle() method in the Repository and passes the title of the image to be fetched
     * @param title
     * @return
     */
    public Image getImageByTitle(String title) {
        return imageRepository.getImageByTitle(title);
    }

    /**
     * The method calls the getImage() method in the Repository and passes the id of the image to be fetched
     * @param imageId
     * @return
     */
    public Image getImage(Integer imageId) {
        return imageRepository.getImage(imageId);
    }

    /**
     * The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
     * @param updatedImage
     */
    public void updateImage(Image updatedImage) {
        imageRepository.updateImage(updatedImage);
    }

    /**
     * The method calls the deleteImage() method in the Repository and passes the Image id of the image to be deleted in the database
     * @param imageId
     */
    public void deleteImage(Integer imageId) {
        imageRepository.deleteImage(imageId);
    }


    /**
     *  This method call saves comment of an Image in the database.
     * @param image
     * @param user
     * @param text
     * @return
     */
	public Comment saveImageComment(Image image, User user, String text) {
		Comment comment = new Comment();
		comment.setCreatedDate(new Date()); 
		comment.setImage(image); 
		comment.setText(text); 
		comment.setUser(user);
 		Comment newComment = imageRepository.saveImageComment(comment);
		return newComment;  
	}

}
