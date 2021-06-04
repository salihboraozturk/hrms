package hrms.hrms.adapter.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrms.core.utilities.image.ImageService;
import hrms.hrms.core.utilities.results.*;

@Service
public class CloudinaryServiceAdapter implements ImageService {
	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryServiceAdapter(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@Override
	public DataResult<Map> uploadPhoto(MultipartFile file) {
		try {
			Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}
}
