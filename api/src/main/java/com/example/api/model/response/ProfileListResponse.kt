package com.example.api.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class ProfileListResponse(
    @SerializedName("invites")
    val invites: Invites,
    @SerializedName("likes")
    val likes: Likes
)

@Keep
data class Invites(
    @SerializedName("pending_invitations_count")
    val pendingInvitationsCount: Int,
    @SerializedName("profiles")
    val profiles: List<Profile>,
    @SerializedName("totalPages")
    val totalPages: Int
)

@Keep
data class Likes(
    @SerializedName("can_see_profile")
    val canSeeProfile: Boolean,
    @SerializedName("likes_received_count")
    val likesReceivedCount: Int,
    @SerializedName("profiles")
    val profiles: List<ProfileX>
)

@Keep
data class Profile(
    @SerializedName("approved_time")
    val approvedTime: Double,
    @SerializedName("general_information")
    val generalInformation: GeneralInformation,
    @SerializedName("has_active_subscription")
    val hasActiveSubscription: Boolean,
    @SerializedName("icebreakers")
    val icebreakers: Any,
    @SerializedName("instagram_images")
    val instagramImages: Any,
    @SerializedName("is_facebook_data_fetched")
    val isFacebookDataFetched: Boolean,
    @SerializedName("last_seen")
    val lastSeen: String,
    @SerializedName("last_seen_window")
    val lastSeenWindow: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("latest_poll")
    val latestPoll: Any,
    @SerializedName("lng")
    val lng: String,
    @SerializedName("meetup")
    val meetup: Any,
    @SerializedName("online_code")
    val onlineCode: Int,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("poll_info")
    val pollInfo: Any,
    @SerializedName("preferences")
    val preferences: List<Preference>,
    @SerializedName("profile_data_list")
    val profileDataList: List<ProfileData>,
    @SerializedName("show_concierge_badge")
    val showConciergeBadge: Boolean,
    @SerializedName("story")
    val story: Any,
    @SerializedName("user_interests")
    val userInterests: List<Any>,
    @SerializedName("verification_status")
    val verificationStatus: String,
    @SerializedName("work")
    val work: Work
)

@Keep
data class GeneralInformation(
    @SerializedName("age")
    val age: Int,
    @SerializedName("cast")
    val cast: Any,
    @SerializedName("date_of_birth")
    val dateOfBirth: String,
    @SerializedName("date_of_birth_v1")
    val dateOfBirthV1: String,
    @SerializedName("diet")
    val diet: Any,
    @SerializedName("drinking")
    val drinking: String,
    @SerializedName("drinking_v1")
    val drinkingV1: DrinkingV1,
    @SerializedName("faith")
    val faith: Faith,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("kid")
    val kid: Any,
    @SerializedName("location")
    val location: Location,
    @SerializedName("marital_status")
    val maritalStatus: String,
    @SerializedName("marital_status_v1")
    val maritalStatusV1: MaritalStatusV1,
    @SerializedName("mother_tongue")
    val motherTongue: MotherTongue,
    @SerializedName("pet")
    val pet: Any,
    @SerializedName("politics")
    val politics: Any,
    @SerializedName("ref_id")
    val refId: String,
    @SerializedName("settle")
    val settle: Any,
    @SerializedName("smoking")
    val smoking: String,
    @SerializedName("smoking_v1")
    val smokingV1: SmokingV1,
    @SerializedName("sun_sign")
    val sunSign: String,
    @SerializedName("sun_sign_v1")
    val sunSignV1: SunSignV1
) : Serializable {
    fun getNameAndAge() = "$firstName, $age"
}

@Keep
data class Photo(
    @SerializedName("photo")
    val photo: String,
    @SerializedName("photo_id")
    val photoId: Int,
    @SerializedName("selected")
    val selected: Boolean,
    @SerializedName("status")
    val status: String
)

@Keep
data class Preference(
    @SerializedName("answer_id")
    val answerId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("preference_question")
    val preferenceQuestion: PreferenceQuestion,
    @SerializedName("value")
    val value: Int
)

@Keep
data class ProfileData(
    @SerializedName("invitation_type")
    val invitationType: String,
    @SerializedName("preferences")
    val preferences: List<PreferenceX>,
    @SerializedName("question")
    val question: String
)

@Keep
data class Work(
    @SerializedName("experience")
    val experience: String,
    @SerializedName("experience_v1")
    val experienceV1: ExperienceV1,
    @SerializedName("field_of_study")
    val fieldOfStudy: String,
    @SerializedName("field_of_study_v1")
    val fieldOfStudyV1: FieldOfStudyV1,
    @SerializedName("highest_qualification")
    val highestQualification: String,
    @SerializedName("highest_qualification_v1")
    val highestQualificationV1: HighestQualificationV1,
    @SerializedName("industry")
    val industry: String,
    @SerializedName("industry_v1")
    val industryV1: IndustryV1,
    @SerializedName("monthly_income_v1")
    val monthlyIncomeV1: Any
)

@Keep
data class DrinkingV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_alias")
    val nameAlias: String
)

@Keep
data class Faith(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

@Keep
data class Location(
    @SerializedName("full")
    val full: String,
    @SerializedName("summary")
    val summary: String
)

@Keep
data class MaritalStatusV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("preference_only")
    val preferenceOnly: Boolean
)

@Keep
data class MotherTongue(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

@Keep
data class SmokingV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_alias")
    val nameAlias: String
)

@Keep
data class SunSignV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

@Keep
data class PreferenceQuestion(
    @SerializedName("first_choice")
    val firstChoice: String,
    @SerializedName("second_choice")
    val secondChoice: String
)

@Keep
data class PreferenceX(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("answer_id")
    val answerId: Int,
    @SerializedName("first_choice")
    val firstChoice: String,
    @SerializedName("second_choice")
    val secondChoice: String
)

@Keep
data class ExperienceV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_alias")
    val nameAlias: String
)

@Keep
data class FieldOfStudyV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

@Keep
data class HighestQualificationV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("preference_only")
    val preferenceOnly: Boolean
)

@Keep
data class IndustryV1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("preference_only")
    val preferenceOnly: Boolean
)

@Keep
data class ProfileX(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("first_name")
    val firstName: String
)