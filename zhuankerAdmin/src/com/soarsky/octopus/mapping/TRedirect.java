package com.soarsky.octopus.mapping;

public class TRedirect{
    private Long id;
    private String  redirect_key;
    private String  redirect_url;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRedirect_key() {
		return redirect_key;
	}
	public void setRedirect_key(String redirect_key) {
		this.redirect_key = redirect_key;
	}
	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}
}
