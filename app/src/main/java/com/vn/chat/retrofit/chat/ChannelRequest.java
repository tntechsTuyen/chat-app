package com.vn.chat.retrofit.chat;

import com.vn.chat.common.response.ApiResponse;
import com.vn.chat.data.Channel;
import com.vn.chat.data.File;
import com.vn.chat.data.Message;
import com.vn.chat.data.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChannelRequest {

    @GET("chat/channel/{channelId}")
    Call<ApiResponse<Channel>> detailChannel(@Path("channelId") String channelId);

    @GET("chat/channel")
    Call<ApiResponse<Channel>> getChannel(@Query("search") String search, @Query("type") String type, @Query("pageNumber") Integer pageNumber, @Query("pageSize") Integer pageSize);

    @POST("chat/channel")
    Call<ApiResponse<Channel>> postChannel(@Body Channel channel);

    @PUT("chat/channel/{channelId}")
    Call<ApiResponse<Channel>> putChannel(@Path("channelId") String channelId, @Body Channel channel);

    @GET("chat/channel/latest-chat")
    Call<ApiResponse<Channel>> getLatestChannel(@Query("pageNumber") Integer pageNumber, @Query("pageSize") Integer pageSize);

    @GET("chat/channel/friend-request")
    Call<ApiResponse<Channel>> getFriendRequest(@Query("type") String type, @Query("pageNumber") Integer pageNumber, @Query("pageSize") Integer pageSize);

    @POST("chat/channel/{channelId}/update-owner")
    Call<ApiResponse<Channel>> updateOwner(@Path("channelId") String channelId, @Body Channel channel);

    @POST("chat/channel/{channelId}/react")
    Call<ApiResponse<Channel>> postReact(@Path("channelId") String channelId, @Body Channel channel);

    @GET("chat/channel/{channelId}/message")
    Call<ApiResponse<Message>> getMessage(@Path("channelId") String channelId, @Query("search") String search, @Query("pageNumber") Integer pageNumber, @Query("pageSize") Integer pageSize);

    @POST("chat/channel/{channelId}/message")
    Call<ApiResponse<Message>> postMessage(@Path("channelId") String channelId, @Body Message message);

    @GET("chat/channel/{channelId}/file")
    Call<ApiResponse<File>> getFiles(@Path("channelId") String channelId, @Query("pageNumber") Integer pageNumber, @Query("pageSize") Integer pageSize);

    @GET("chat/channel/{channelId}/to-add-group")
    Call<ApiResponse<User>> getUserAdd(@Path("channelId") String channelId, @Query("search") String search);

    @GET("chat/channel/{channelId}/member")
    Call<ApiResponse<User>> getMembers(@Path("channelId") String channelId, @Query("status") String status);

    @POST("chat/channel/{channelId}/member")
    Call<ApiResponse<User>> postMember(@Path("channelId") String channelId, @Body Channel channel);

    @POST("chat/channel/{channelId}/react-owner")
    Call<ApiResponse<User>> postReactOwner(@Path("channelId") String channelId, @Body Channel channel);
}
