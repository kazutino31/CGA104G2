package com.activityphoto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import com.activity.common.HibernateUtil;
import com.activity.model.ActivityVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACTIVITY_PHOTO",catalog = "Community_Management")
public class ActivityPhotoVO implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTIVITY_PHOTO_ID")
	private Integer actPhotoId;
	@Column(name = "ACTIVITY_ID")
	private Integer actId;
	@Column(name = "ACTIVITY_PHOTO")
	private byte[] actPhoto;
	
	@ManyToOne
	@JoinColumn(name="ACTIVITY_ID" ,insertable=false ,updatable=false)
	private ActivityVO activityVO;
	

}
